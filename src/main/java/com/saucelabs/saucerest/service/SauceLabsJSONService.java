package com.saucelabs.saucerest.service;

/**
 * Created by mehmetg on 4/8/16.
 */
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.saucelabs.saucerest.models.tx.JobDetails;
import com.saucelabs.saucerest.models.tx.NewSubUser;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Date;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public interface SauceLabsJSONService {
    @GET("v1/users/{username}")
    Call<ResponseBody> getUser(@Path("username") String username);

    @POST("v1/users/{username}")
    Call<ResponseBody> postSubUser(@Path("username") String username, @Body NewSubUser user);

    @GET("v1/users/{username}/list-subaccounts")
    Call<ResponseBody> getSubAccountsList(@Path("username") String username);

    @GET("v1/users/{username}/subaccounts")
    Call<ResponseBody> getSubAccounts(@Path("username") String username);

    @GET("v1/hello")
    Call<ResponseBody> getHello();

    @GET("v1/blow")
    Call<ResponseBody> getBlow();

    @GET("v1/world")
    Call<ResponseBody> getWorld();

    @GET("v1/admin/activity/{level}/{user}")
    Call<ResponseBody> getActivity(@Path("level") String level, @Path("user") String user);

    @GET("v1/archives/search")
    Call<ResponseBody> getArchiveSearch(); //FIXME query params

    @GET("v1/archives/validate_query")
    Call<ResponseBody> getArchiveQueryVaidation(); //FIXME query params

    @GET("v1.1/users/{username}/concurrency")
    Call<ResponseBody> getConcurrency(@Path("username") String username);

    @GET("v1.1/users/{username}/siblings")
    Call<ResponseBody> getSiblings(@Path("username") String username);

    @GET("v1/info/status")
    Call<ResponseBody> getStatus();

    @GET("v1/info/platforms/{automation_api}")
    Call<ResponseBody> getSupportedPlatforms(@Path("automation_api") String automation_api);

    @GET("v1.1/{username}/jobs")
    Call<ResponseBody> getJobs(@Path("username") String username,
                               @Query("number_of_jobs") Integer numberOfJobs,
                               @Query("full") Boolean getFullInfo,
                               @Query("skip") Integer numberOfJobsToSkip,
                               @Query("from") Date fromDate,
                               @Query("to") Date toDate,
                               @Query("format") String format);

    @GET("v1/{username}/jobs/{job_id}")
    Call<ResponseBody> getJob(@Path("username") String username,
                               @Path("job_id") String jobId);

    @PUT("v1/{username}/jobs/{job_id}")
    Call<ResponseBody> putJobUpdate(@Path("username") String username,
                               @Path("job_id") String jobId,
                               @Body JobDetails jobDetails);

    @PUT("v1/{username}/jobs/{job_id}/stop")
    Call<ResponseBody> putJobStop(@Path("username") String username,
                               @Path("job_id") String jobId);

    @GET("v1/{username}/jobs/{job_id}/assets")
    Call<ResponseBody> getJobAssets(@Path("username") String username,
                                    @Path("job_id") String jobId);

    @DELETE("v1/{username}/jobs/{job_id}/assets")
    Call<ResponseBody> deleteJobAssets(@Path("username") String username,
                                    @Path("job_id") String jobId);

    @GET("v1/{username}/jobs/{job_id}/assets/{file_name}")
    Call<ResponseBody> getJobAsset(@Path("username") String username,
                                   @Path("job_id") String jobId,
                                   @Path("file_name") String filename);


   /* @GET("/rest/v1/archives/facet_search/{field_name}")


    @DELETE("/rest/v1/archives")

    @GET("/rest/v1/bugs/types")

    @GET("/rest/v1/bugs/types/{type}")

    @GET("/rest/v1/bugs/detail/{id}")

    @GET("/rest/v1/bugs/query/")

    @GET("/rest/v1/bugs/update/{id}")
    @GET("/rest/v1/{username}/bugs")
    @GET("/rest/v1.1/{user}/builds_safe")
    @GET("/rest/v1.1/{username}/builds")
    @GET("/rest/v1/{user}/builds/{name}")
    @GET("/rest/v1/builds/{build_id}")
    @GET("/rest/v1/{user}/builds/{build_id}/failed-jobs")
    @GET("/rest/v1/builds/{build_id}/assets")
    @GET("/rest/v1/builds/{build_id}/assets/{asset_id}")
    @GET("/rest/v1/users/{username}/concurrency")
    @GET("/rest/v1.1/users/{username}/concurrency")
    @GET("/rest/v1/users/{user}/concurrency-history")
    @DELETE("/rest/v1/users/{username}/scout/{cyborg_id}")
    @POST("/rest/v1/tasks")
    @GET("/rest/v1/dashboard_messages/{user}")
    @PUT("/rest/v1/dashboard_messages/{message_id}")
    @GET("/rest/v1/dashboard/full/{username}/{start}/{end}")
    @GET("/rest/v1/dashboard/cached/{username}/{year}/{month}")
    @GET("/rest/v1/{username}/defaults")
    @PUT("/rest/v1/{username}/defaults")
    @POST("/rest/v1/{user}/email/share")
    @POST("/rest/v1/{username}/errors")
    @GET("/rest/v1.1/info/browsers")
    @GET("/rest/v1/info/browsers")
    @GET("/rest/v1/info/platforms/all")
    @GET("/rest/v1.1/info/platforms/all")
    @GET("/rest/v1/info/browsers/all")
    @GET("/rest/v1/info/platforms/selenium-rc")
    @GET("/rest/v1/info/platforms/webdriver")
    @GET("/rest/v1/info/platforms/appium")
    @GET("/rest/v1/info/platforms/appium/eol")
    @GET("/rest/v1/info/status")
    @GET("/rest/v1/info/counter")
    @GET("/rest/v1.2/info/scout")
    @GET("/rest/v1.1/info/scout")
    @GET("/rest/v1/info/scout")
    @GET("/rest/v1/info/scout/sanitized")
    @GET("/rest/v1/info/test/cache/{username}")
    @PUT("/rest/v1/{user}/jobs/{id}/stop")
    @GET("/rest/v1/{username}/jobs")
    @GET("/rest/v1/{username}/jobs_safe")
    @GET("/rest/v1.1/{username}/jobs")
    @GET("/rest/v1.1/{username}/sample-jobs")
    @GET("/rest/v1/{user}/build/{build_name}/jobs")
    @GET("/rest/v1/builds/{build_id}/jobs")
    @GET("/rest/v1/builds/{build_id}/updated_jobs")
    @GET("/rest/v1/{username}/activity")
    @GET("/rest/v1/{username}/updated_jobs")
    @GET("/rest/v1/{username}/updated_jobs_safe")
    @GET("/rest/v1.1/{username}/updated_jobs")
    @GET("/rest/v1/{username}/jobs/{id}")
    @GET("/rest/v1.1/{username}/jobs/{id}")
    @GET("/rest/v1/{username}/jobs/{id}/assets")
    @DELETE("/rest/v1/{username}/jobs/{id}/assets")
    @GET("/rest/v1/{username}/jobs/{id}/assets/{asset}")
    @GET("/rest/v1/jobs/{id}")
    @GET("/rest/v1.1/jobs/{id}")
    @GET("/rest/v1/jobs/{id}/assets")
    @GET("/rest/v1/jobs/{id}/task_id")
    @GET("/rest/v1/jobs/{id}/{asset}")
    @GET("/rest/{username}/jobs/{id}/results/{asset}")
    @POST("/rest/v1/{username}/jobs")
    @PUT("/rest/v1/{username}/jobs/{id}")
    @DELETE("/rest/v1/{username}/jobs/{id}")
    @GET("/rest/{username}/in-progress-jobs")
    @GET("/rest/{username}/jobs/recent")
    @GET("/rest/{username}/jobs/{id}")
    @POST("/rest/v1/{username}/js-tests")
    @POST("/rest/v1/{username}/js-tests/status")
    @GET("SOME_URL_WITH/{task_id}")
    @GET("/rest/v1/manual/options")
    @GET("/rest/v1/manual/options/{browser_name}")
    @GET("/rest/v1/manual/{task_id}")
    @POST("/rest/v1/manual")
    @DELETE("/rest/v1/manual")
    @POST("/rest/v1/manual/{task_id}/screenshot")
    @POST("/rest/v1/{user}/message")
    @GET("/rest/v1/{user}/message/list")
    @PUT("/rest/v1/{user}/message/{id}")
    @DELETE("/rest/v1/{user}/message/{id}")
    @GET("/rest/conf/browsers")
    @GET("/rest/validate-key")
    @GET("/rest/test-rest-auth/{username}")
    @POST("/rest/v1/users/{user}/promotion/validate")
    @POST("/rest/v1/users/{user}/promotion/submit")
    @PUT("/rest/v1/ratelimit/ping")
    @GET("/rest/v1/ratelimit/ping")
    @POST("/rest/v1/restricted_mode/{user}/domain")
    @PUT("/rest/v1/restricted_mode/{user}/domain")
    @GET("/rest/v1/{user}/saml")
    @PUT("/rest/v1/{user}/saml")
    @POST("/rest/v1/{user}/saml")
    @POST("/rest/v1/stats/ci")
    @GET("/rest/v1/storage/{username}")
    @POST("/rest/v1/storage/{username}/{filename}")
    @GET("/rest/v1/suggestions")
    @GET("URL_WITH/{user}/suites/{suite_id}")
    @GET("/rest/v1/{user}/suites")
    @POST("/rest/v1/{user}/suites")
    @PUT("/rest/v1/{user}/suites/{suite_id}")
    @DELETE("/rest/v1/{user}/suites/{suite_id}")
    @GET("/rest/v1/{user}/suites/{suite_id}")
    @POST("/rest/v1/{user}/suites/{suite_id}/start")
    @POST("/rest/v1/{user}/suites/{suite_id}/{build_id}")
    @GET("/rest/v1/{username}/tunnels")
    @GET("/rest/v1/{username}/tunnels_safe")
    @GET("/rest/v1/{username}/available_tunnels")
    @GET("/rest/v1.1/{username}/available_tunnels")
    @GET("/rest/v1/{username}/all_tunnels")
    @POST("/rest/v1/{username}/tunnels")
    @GET("/rest/v1/{username}/tunnels/{id}")
    @PUT("/rest/v1/{username}/tunnels/{id}")
    @POST("/rest/v1/{username}/tunnels/{id}/connected")
    @DELETE("/rest/v1/{username}/tunnels/{id}")
    @GET("/rest/{user}/needs_tunnel/{domain}")
    @GET("/rest/v1/users")
    @GET("/rest/v1/users/{username}")
    @POST("/rest/v1/users/{user}/accesskey/change")
    @POST("/rest/v1/users/accesskey/change")
    @POST("/rest/v1/users/accesskey/change-all")
    @DELETE("/rest/v1/users")
    @GET("/rest/v1/users/{user}/list-subaccounts")
    @GET("/rest/v1/users/{user}/list-subaccount-matches")
    @GET("/rest/v1/users/{user}/siblings")
    @GET("/rest/v1.1/users/{user}/siblings")
    @GET("/rest/v1/users/{user}/subaccounts")
    @GET("/rest/v1/users/{username}/ancestry")
    @POST("/rest/v1/users/{user}/scout")
    @GET("/rest/v1/users/{user}/subscription")
    @POST("/rest/v1/users/{username}/subscription")
    @DELETE("/rest/v1/users/{user}/subscription")
    @GET("/rest/v1/users/{user}/usage")
    @GET("/rest/v1.1/users/{user}/usage")
    @GET("/rest/v1/{user}/limits")
    @GET("/rest/v1/users/{user}/monthly-minutes")
    @POST("/rest/v1/can_run_job")
    @PUT("/rest/v1/users/{user}/preferences")
    @POST("/rest/v1/prevent_emails")
    @POST("/rest/v1/{username}/reset/{subaccount}")
    @GET("/rest/v1/users/{user}/activity")
    @PUT("/rest/v1/users/{user}/update")
    @GET("/rest/v1/users/{user}/invoices")
    @GET("/rest/v1/users/{user}/billing-info")
    @PUT("/rest/v1/users/{user}/billing-info")*/




}


