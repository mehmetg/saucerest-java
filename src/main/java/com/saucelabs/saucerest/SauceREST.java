package com.saucelabs.saucerest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.saucelabs.saucerest.models.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.DateUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.io.File;
import java.net.*;
import java.rmi.UnexpectedException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple Java API that invokes the Sauce REST API.  The full list of the Sauce REST API functionality is available from
 * <a href="https://docs.saucelabs.com/reference/rest-api">https://docs.saucelabs.com/reference/rest-api</a>.
 *
 * @author Ross Rowe
 */
public class SauceREST {
    private static final String HMAC_KEY = "HMACMD5";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Logger instance.
     */
    private static final Logger logger = Logger.getLogger(SauceREST.class.getName());
    /**
     * 10 seconds in milliseconds.
     */
    private static final long HTTP_READ_TIMEOUT_SECONDS = TimeUnit.SECONDS.toMillis(10);
    /**
     * 10 seconds in milliseconds.
     */
    private static final long HTTP_CONNECT_TIMEOUT_SECONDS = TimeUnit.SECONDS.toMillis(10);
    /**
     * The username to use when performing HTTP requests to the Sauce REST API.
     */
    protected String username;
    /**
     * The access key to use when performing HTTP requests to the Sauce REST API.
     */
    protected String accessKey;

    /**
     * The initial component of the Sauce REST API URL.
     */
    public static final String RESTURL = "https://saucelabs.com/rest/v1/%1$s";
    /**
     * The String format used to retrieve Sauce Job results for a specific user from the Sauce REST API.
     */
    private static final String USER_RESULT_FORMAT = RESTURL + "/%2$s";
    /**
     * The String format used to retrieve the jobs information via the Sauce REST API.
     */
    private static final String GET_JOBS_FORMAT = RESTURL + "/jobs";
    /**
     * The String format used to retrieve Sauce Job results from the Sauce REST API.
     */
    private static final String JOB_RESULT_FORMAT = GET_JOBS_FORMAT + "/%2$s";
    /**
     * The String format used to stop a running job via the Sauce REST API.
     */
    private static final String STOP_JOB_FORMAT = JOB_RESULT_FORMAT + "/stop";
    /**
     * The String format used to download a video for a Sauce job via the Sauce REST API.
     */
    private static final String DOWNLOAD_VIDEO_FORMAT = JOB_RESULT_FORMAT + "/assets/video.flv";
    /**
     * The String format used to download a log for a Sauce job via the Sauce REST API.
     */
    private static final String DOWNLOAD_LOG_FORMAT = JOB_RESULT_FORMAT + "/assets/selenium-server.log";
    /**
     * The String format used to retrieve the tunnel information via the Sauce REST API.
     */
    private static final String GET_TUNNELS_FORMAT = RESTURL + "/tunnels";
    /**
     * The String format used to retrieve the user activity information via the Sauce REST API.
     */
    private static final String GET_ACTIVITY_FORMAT = RESTURL + "/activity";
    /**
     * The String format used to delete a tunnel via the Sauce REST API.
     */
    private static final String GET_TUNNEL_FORMAT = GET_TUNNELS_FORMAT + "/%2$s";
    /**
     * The String format used to retrieve the user concurrency information via the Sauce REST API.
     */
    private static final String GET_CONCURRENCY_FORMAT = USER_RESULT_FORMAT + "/concurrency";
    /**
     * Date format used as part of the file name for downloaded files.
     */
    private static final String DATE_FORMAT = "yyyyMMdd_HHmmSS";

    private String server;
    private static final String BASE_URL = System.getenv("SAUCE_REST_ENDPOINT") != null ? System.getenv("SAUCE_REST_ENDPOINT") : "https://saucelabs.com/";

    /**
     * Constructs a new instance of the SauceREST class.
     *
     * @param username  The username to use when performing HTTP requests to the Sauce REST API
     * @param accessKey The access key to use when performing HTTP requests to the Sauce REST API
     */
    public SauceREST(String username, String accessKey) {
        this.username = username;
        this.accessKey = accessKey;
        this.server = BASE_URL;
    }

    /**
     * Returns username assigned to this interface
     *
     * @return Returns username assigned to this interface
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Build the url to be
     *
     * @param endpoint    Endpoint url, example "info/platforms/appium"
     * @return URL to use in direct fetch functions
     */
    protected URL buildURL(String endpoint) {
        try {
            return new URL(new URL(this.server), "/rest/" + endpoint);
        } catch (MalformedURLException e) {
            logger.log(Level.WARNING, "Error constructing Sauce URL", e);
            return null;
        }
    }

    protected String getUserAgent() {
        return "SauceREST/" + SauceREST.class.getPackage().getImplementationVersion();
    }

    public String doREST(String method, URL url, JSONObject body) throws SauceException
    {
        HttpURLConnection postBack = null;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;

        try {
            postBack = openConnection(url);
            postBack.setRequestProperty("SauceUser-Agent", this.getUserAgent());

            if (postBack instanceof HttpsURLConnection) {
                SauceSSLSocketFactory factory = new SauceSSLSocketFactory();
                ((HttpsURLConnection) postBack).setSSLSocketFactory(factory);
            }
            postBack.setDoOutput(true);
            postBack.setRequestMethod(method);
            postBack.setRequestProperty("Content-Type", "application/json");
            addAuthenticationProperty(postBack);

            if (body != null) {
                String jsonText = JSONValue.toJSONString(body);
                postBack.getOutputStream().write(jsonText.getBytes());
            } else {
                postBack.getOutputStream().write("".getBytes());
            }

            reader = new BufferedReader(new InputStreamReader(postBack.getInputStream()));

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                builder.append(inputLine);
            }
        } catch (IOException e) {
            try {
                if (postBack.getResponseCode() == 401) {
                    throw new SauceException.NotAuthorized();
                }
            } catch (IOException e1) {
                logger.log(Level.SEVERE, "Error POSTing to " + url.toString() + " and getting status code: ", e);
            }

            logger.log(Level.SEVERE, "Error POSTing to " + url.toString() + ":", e);
        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Error POSTing to " + url.toString() + ":", e);
        } catch (KeyManagementException e) {
            logger.log(Level.SEVERE, "Error POSTing to " + url.toString() + ":", e);
        } finally {
            closeInputStream(postBack);
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.log(Level.WARNING, "Error closing Sauce input stream", e);
            }
        }
        return builder.toString();
    }

    /**
     * Returns a String (in JSON format) representing the details for a Sauce job.
     *
     * @param jobId the Sauce Job id to retrieve
     * @return String (in JSON format) representing the details for a Sauce job
     */
    public Job getJobInfo(String jobId) {
        URL restEndpoint = this.buildURL("v1/" + username + "/jobs/" + jobId);
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Stores the result of a HTTP GET to the value of the <code>restEndpoint</code> parameter,
     * saving the resulting file to the directory defined by the <code>location</code> parameter.
     *
     * @param jobId        the Sauce Job id
     * @param location     represents the location that the result file should be stored in
     * @param restEndpoint the URL to perform a HTTP GET
     */
    private void downloadFile(String jobId, String location, URL restEndpoint) {
        BufferedOutputStream out = null;
        try {
            HttpURLConnection connection = openConnection(restEndpoint);
            connection.setRequestProperty("SauceUser-Agent", this.getUserAgent());

            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            addAuthenticationProperty(connection);

            InputStream stream = connection.getInputStream();
            BufferedInputStream in = new BufferedInputStream(stream);
            SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
            String saveName = jobId + format.format(new Date());
            if (restEndpoint.getPath().endsWith(".flv")) {
                saveName = saveName + ".flv";
            } else {
                saveName = saveName + ".log";
            }
            FileOutputStream file = new FileOutputStream(new File(location, saveName));
            out = new BufferedOutputStream(file);
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            out.flush();
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error downloading Sauce Results");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    //ignore
                }
            }
        }

    }

    /**
     * Adds an Authorization request property to the HTTP connection.
     *
     * @param connection HttpURLConnection instance which represents the current HTTP request
     */
    protected void addAuthenticationProperty(HttpURLConnection connection) {
        if (username != null && accessKey != null) {
            String auth = encodeAuthentication();
            connection.setRequestProperty("Authorization", auth);
        }
    }

    /**
     * Invokes the Sauce REST API to update the details of a Sauce job, using the details included in the <code>updates</code>
     * parameter.
     *
     * @param jobId   the Sauce job id to update
     * @param updates Map of attributes to update
     */
    public void updateJobInfo(String jobId, Map<String, Object> updates) {
        HttpURLConnection postBack = null;
        try {
            URL restEndpoint = new URL(String.format(JOB_RESULT_FORMAT, username, jobId));
            postBack = openConnection(restEndpoint);
            postBack.setRequestProperty("SauceUser-Agent", this.getUserAgent());
            postBack.setDoOutput(true);
            postBack.setRequestMethod("PUT");
            addAuthenticationProperty(postBack);
            String jsonText = JSONValue.toJSONString(updates);
            postBack.getOutputStream().write(jsonText.getBytes());
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error updating Sauce Results", e);
        }

        closeInputStream(postBack);

    }

    /**
     * Invokes the Sauce REST API to stop a running job.
     *
     * @param jobId the Sauce Job id
     */
    public void stopJob(String jobId) {
        URL restEndpoint = this.buildURL("v1/" + username + "/jobs/" + jobId + "/stop");
        doREST("PUT", restEndpoint, null);
    }

    private void closeInputStream(HttpURLConnection connection) {
        try {
            if (connection != null) {
                connection.getInputStream().close();
            }
        } catch (SocketTimeoutException e) {
            logger.log(Level.SEVERE, "Received a SocketTimeoutException when invoking Sauce REST API, check status.saucelabs.com for network outages", e);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error closing result stream", e);
        }

    }

    /**
     * Opens a connection to a url.
     *
     * @param url URL to connect to
     * @return HttpURLConnection instance representing the URL connection
     * @throws IOException when a bad url is provided
     */
    public HttpURLConnection openConnection(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setReadTimeout((int) HTTP_READ_TIMEOUT_SECONDS);
        con.setConnectTimeout((int) HTTP_CONNECT_TIMEOUT_SECONDS);
        return con;
    }

    /**
     * Uploads a file to Sauce storage.
     *
     * @param file the file to upload
     *             -param fileName uses file.getName() to store in sauce
     *             -param overwrite set to true
     * @return the md5 hash returned by sauce of the file
     * @throws IOException can be thrown when server returns an error (tcp or http status not in the 200 range)
     */
    public String uploadFile(File file) throws IOException {
        return uploadFile(file, file.getName());
    }

    /**
     * Uploads a file to Sauce storage.
     *
     * @param file     the file to upload
     * @param fileName name of the file in sauce storage
     *                 -param overwrite set to true
     * @return the md5 hash returned by sauce of the file
     * @throws IOException can be thrown when server returns an error (tcp or http status not in the 200 range)
     */
    public String uploadFile(File file, String fileName) throws IOException {
        return uploadFile(file, fileName, true);
    }

    /**
     * Uploads a file to Sauce storage.
     *
     * @param file      the file to upload
     * @param fileName  name of the file in sauce storage
     * @param overwrite boolean flag to overwrite file in sauce storage if it exists
     * @return the md5 hash returned by sauce of the file
     * @throws IOException can be thrown when server returns an error (tcp or http status not in the 200 range)
     */
    public String uploadFile(File file, String fileName, Boolean overwrite) throws IOException {

        CookieSpecProvider customSpecProvider = new CookieSpecProvider() {
            public CookieSpec create(HttpContext context) {
                return new BrowserCompatSpec(new String[]{DateUtils.PATTERN_RFC1123,
                    DateUtils.PATTERN_RFC1036,
                    DateUtils.PATTERN_ASCTIME,
                    "\"EEE, dd-MMM-yyyy HH:mm:ss z\""});
            }

        };
        Registry<CookieSpecProvider> r = RegistryBuilder.<CookieSpecProvider>create()
                .register(CookieSpecs.BEST_MATCH,
                        new BestMatchSpecFactory())
                .register("custom", customSpecProvider)
                .build();

        RequestConfig requestConfig = RequestConfig.custom()
                .setCookieSpec("custom")
                .build();

        CloseableHttpClient client = HttpClients.custom()
                .setDefaultCookieSpecRegistry(r)
                .setDefaultRequestConfig(requestConfig)
                .build();

        HttpClientContext context = HttpClientContext.create();
        context.setCookieSpecRegistry(r);

        HttpPost post = new HttpPost(String.format(RESTURL, "storage/")
                + username + "/" + fileName + "?overwrite=" + overwrite.toString());

        FileEntity entity = new FileEntity(file);
        entity.setContentType(new BasicHeader("Content-Type",
                "application/octet-stream"));
        post.setEntity(entity);

        post.setHeader("Content-Type", "application/octet-stream");
        post.setHeader("Authorization", encodeAuthentication());
        HttpResponse response = client.execute(post, context);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            builder.append(line);
        }

        try {
            JSONObject sauceUploadResponse = new JSONObject(builder.toString());
            if (sauceUploadResponse.has("error")) {
                throw new UnexpectedException("Failed to upload to sauce-storage: "
                        + sauceUploadResponse.getString("error"));
            }
            return sauceUploadResponse.getString("md5");
        } catch (JSONException j) {
            throw new UnexpectedException("Failed to parse json response.", j);
        }

    }

    /**
     * Generates a link to the job page on Saucelabs.com, which can be accessed
     * without the user's credentials. Auth token is HMAC/MD5 of the job ID
     * with the key &lt;username&gt;:&lt;api key&gt;
     * (see <a href="http://saucelabs.com/docs/integration#public-job-links">http://saucelabs.com/docs/integration#public-job-links</a>).
     *
     * @param jobId the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
     * @return link to the job page with authorization token
     */
    public String getPublicJobLink(String jobId) {
        return "https://saucelabs.com/jobs/" + jobId + "?auth=" + calcHMAC(username, accessKey, jobId);
    }

    /**
     * @return base64 encoded String representing the username/access key
     */
    protected String encodeAuthentication() {
        String auth = username + ":" + accessKey;
        auth = "Basic " + DatatypeConverter.printBase64Binary(auth.getBytes());
        return auth;
    }

    /**
     * Invokes the Sauce REST API to delete a tunnel.
     *
     * @param tunnelId Identifier of the tunnel to delete
     */
    public void deleteTunnel(String tunnelId) {
        URL restEndpoint = this.buildURL("v1/" + username + "/tunnels/" + tunnelId);
        doREST("DELETE", restEndpoint, null);
    }

    /**
     * Invokes the Sauce REST API to retrieve the details of the tunnels currently associated with the user.
     *
     * @return ArrayList of tunnel ids
     */
    public ArrayList<String> getTunnels() {
        URL restEndpoint = this.buildURL("v1/" + username + "/tunnels");
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, new TypeReference<ArrayList<String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Invokes the Sauce REST API to retrieve the details of the tunnels currently associated with the user.
     *
     * @return Fully expanded list of tunnels
     */
    public ArrayList<Tunnel> getFullTunnels() {
        URL restEndpoint = this.buildURL("v1/" + username + "/tunnels?full=1");
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, new TypeReference<ArrayList<Tunnel>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Invokes the Sauce REST API to retrieve the details of the tunnel.
     *
     * @param tunnelId the Sauce Tunnel id
     * @return String (in JSON format) representing the tunnel information
     */
    public Tunnel getTunnelInformation(String tunnelId) {
        URL restEndpoint = this.buildURL("v1/" + username + "/tunnels/" + tunnelId);
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, Tunnel.class);
        } catch (UnrecognizedPropertyException e) {
            if ("errors".equals(e.getPropertyName())) {
                return null; // FIXME
            }
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Invokes the Sauce REST API to retrieve the concurrency details of the user.
     *
     * @return String (in JSON format) representing the concurrency information
     */
    public Concurrency getConcurrency() {
        URL restEndpoint = null;
        try {
            restEndpoint = new URL(String.format(GET_CONCURRENCY_FORMAT, "users", username));
        } catch (MalformedURLException e) {
            logger.log(Level.WARNING, "Error constructing Sauce URL", e);
        }
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, Concurrency.class);
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Invokes the Sauce REST API to retrieve the activity details of the user.
     *
     * @return String (in JSON format) representing the activity information
     */
    public Activity getActivity() {
        URL restEndpoint = null;
        try {
            restEndpoint = new URL(String.format(GET_ACTIVITY_FORMAT, username));
        } catch (MalformedURLException e) {
            logger.log(Level.WARNING, "Error constructing Sauce URL", e);
        }
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, Activity.class);
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * @param build Build Name
     * @param full Should just return full job information
     * @return API Results
     */
    public List<Job> getBuildJobs(String build, boolean full) throws SauceException {
        URL restEndpoint = this.buildURL("v1/" + this.getUsername() + "/build/" + build + "/jobs" + (full ? "?full=1" : ""));
        String json = doREST("GET", restEndpoint, null);
        try {
            RootObject root = mapper.readValue(json, RootObject.class);
            return root.getJobs();
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Returns a String (in JSON format) representing the stored files list
     *
     * @return String (in JSON format) representing the stored files list
     */
    public List<com.saucelabs.saucerest.models.File> getStoredFiles() {
        URL restEndpoint = null;
        try {
            restEndpoint = new URL(String.format(RESTURL, "storage") + "/" + username);
        } catch (MalformedURLException e) {
            logger.log(Level.WARNING, "Error constructing Sauce URL", e);
        }
        String json = doREST("GET", restEndpoint, null);
        try {
            RootObject root = mapper.readValue(json, RootObject.class);
            return root.getFiles();
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Returns a String (in JSON format) representing the basic account information
     *
     * @return String (in JSON format) representing the basic account information
     */
    public User getUser() {
        URL restEndpoint = null;
        try {
            restEndpoint = new URL(String.format(USER_RESULT_FORMAT, "users", username));
        } catch (MalformedURLException e) {
            logger.log(Level.WARNING, "Error constructing Sauce URL", e);
        }
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, User.class);
        } catch (UnrecognizedPropertyException e) {
            if ("errors".equals(e.getPropertyName())) {
                return null; // FIXME
            }
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    /**
     * Returns a String (in JSON format) representing the list of models describing all the OS and browser platforms
     * currently supported on Sauce Labs.
     * (see <a href="https://docs.saucelabs.com/reference/rest-api/#get-supported-platforms">https://docs.saucelabs.com/reference/rest-api/#get-supported-platforms</a>).
     * @param automationApi the automation API name
     * @return String (in JSON format) representing the supported platforms information
     */
    public List<Platform> getSupportedPlatforms(String automationApi) {
        URL restEndpoint = this.buildURL("v1/info/platforms/" + automationApi);
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, new TypeReference<ArrayList<Platform>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }

    public SauceStatus getStatus() {
        URL restEndpoint = this.buildURL("v1/info/status");
        String json = doREST("GET", restEndpoint, null);
        try {
            return mapper.readValue(json, SauceStatus.class);
        } catch (IOException e) {
            e.printStackTrace();
            // FIXME - this should be its own exception
        }
        return null;
    }



    /**
     * Record CI Usage to Sauce Labs
     *
     * @param platform Platform string. Such as "jenkins", "bamboo", "teamcity"
     * @param platformVersion Version string. Such as "1.1.1"
     * @return if it was a success or not
     */
    public boolean recordCI(String platform, String platformVersion) {
        URL restEndpoint = this.buildURL("v1/stats/ci");
        JSONObject obj = new JSONObject();
        try {
            obj.put("platform", platform);
            obj.put("platform_version", platformVersion);
        } catch (JSONException e) {
            // JSONException - If the key is null.
            logger.log(Level.SEVERE, "Error attempting to craft json:", e);
            return false;
        }

        try {
            doREST("POST", restEndpoint, obj);
        } catch (SauceException e) {
            return false;
        }
        return true;
    }

    /**
     * @param username Sauce Username
     * @param accessKey Sauce Access key
     * @param jobId job id
     * @return HMAC token
     * @throws NoSuchAlgorithmException     thrown if an error occurs generating the key
     * @throws InvalidKeyException          thrown if an error occurs generating the key
     * @throws UnsupportedEncodingException thrown if an error occurs generating the key
     */
    public String calcHMAC(String username, String accessKey, String jobId) {
        String key = username + ":" + accessKey;
        return SecurityUtils.hmacEncode("HmacMD5", jobId, key);
    }
}
