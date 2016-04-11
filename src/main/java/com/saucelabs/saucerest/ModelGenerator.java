package com.saucelabs.saucerest;

import com.saucelabs.saucerest.models.Constants;
import com.saucelabs.saucerest.models.tx.NewSubUser;
import com.saucelabs.saucerest.service.SauceLabsJSONService;
import com.saucelabs.saucerest.service.SauceLabsServiceGenerator;
import com.sun.codemodel.JCodeModel;
import okhttp3.ResponseBody;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;

/**
 * Created by mehmetg on 4/8/16.
 */
public class ModelGenerator {
    public static void main(String[] args) {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");
        SauceLabsJSONService jsonService =
                SauceLabsServiceGenerator.createService(SauceLabsJSONService.class, username, accessKey);
/*      Call<ResponseBody> apiCall = jsonService.getUser(username);
        generateModel("SauceUser", apiCall);
        Call<ResponseBody> apiCall = jsonService.getHello();
        generateModel("Hello", apiCall);
        apiCall = jsonService.getSubAccountsList(username);
        generateModel("SauceSubUsers", apiCall);
        apiCall = jsonService.getWorld();
        generateModel("Hello", apiCall);
        apiCall = jsonService.getConcurrency(username);
        generateModel("Concurrency", apiCall);
        Call<ResponseBody> apiCall = jsonService.getSiblings(username);
        generateModel("Siblings", apiCall);

        Call<ResponseBody> apiCall = jsonService.postSubUser(username,
                new NewSubUser("test_1112", "hello123", "FirstLast", "hede334@mail.com"));
        generateModel("NewSubUserResponse", apiCall);
        Call<ResponseBody> apiCall = jsonService.getStatus();
        generateModel("Status", apiCall);
        Call<ResponseBody> apiCall = jsonService.getSupportedPlatforms(Constants.AUTOMATION_API_ALL);
        generateModel("SupportedPlatforms", apiCall);*/
        Call<ResponseBody> apiCall = jsonService.getJobs(username, null);
        generateModel("Jobs", apiCall);

    }
    private static void generateModel(String className, Call<ResponseBody> apiCall){
        JCodeModel codeModel = new JCodeModel();
        String json = null;
        try {
            Response r = apiCall.execute();
            if ((r.code() == 200 || r.code() == 201) && r.body() != null) {
                json = ((ResponseBody)r.body()).string();
            } else {
                System.out.format("Error code: %d", r.code());
                System.out.format("Error body: %s", r.errorBody().string());
                return;
            }
            System.out.println(json);
            GenerationConfig config = new DefaultGenerationConfig() {
                @Override
                public boolean isGenerateBuilders() { // set config option by overriding method
                    return true;
                }
                @Override
                public SourceType getSourceType() {
                    return SourceType.JSON;
                }
                @Override
                public boolean isIncludeDynamicAccessors() {
                    return false;
                }
                @Override
                public boolean isIncludeAdditionalProperties() {
                    return false;
                }
            };

            SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(), new SchemaStore()), new SchemaGenerator());
            mapper.generate(codeModel, className, "com.saucelabs.saucerest.models.rx", json);
            codeModel.build(new File("src/main/java"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
