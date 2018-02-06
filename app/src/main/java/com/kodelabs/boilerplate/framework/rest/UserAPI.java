package com.kodelabs.boilerplate.framework.rest;

import com.kodelabs.boilerplate.domain.model.RandomUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jsivianes on 5/2/18.
 */

public interface UserAPI {

    String SERVICE_ENDPOINT = "https://randomuser.me/";

    /**
     * @param results the number of results (users) to generate
     * @return An Observable object that contains the response
     */
    @GET("api/")
    Observable<RandomUserResponse> getRandomUsers(@Query("results") Integer results);

    @GET("api/")
    Call<RandomUserResponse> getUsers(@Query("results") Integer results);

    class Factory {
        public static UserAPI create() {
            return APIClient.createRetrofitService(UserAPI.class, SERVICE_ENDPOINT);
        }
    }
}
