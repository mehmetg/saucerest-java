package com.saucelabs.saucerest.service;

/**
 * Created by mehmetg on 4/8/16.
 */
import com.saucelabs.saucerest.objects.SauceSubUsers;
import com.saucelabs.saucerest.objects.SauceUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
public interface SauceLabsPOJOService {
    @GET("users/{username}")
    Call<SauceUser> getUser(@Path("username") String username);

    @GET("users/{username}/list-subaccounts")
    Call<SauceSubUsers> getSubAccountsList(@Path("username") String username);

    @GET("users/{username}/subaccounts")
    Call<List<SauceUser>> getSubAccounts(@Path("username") String username);
}


