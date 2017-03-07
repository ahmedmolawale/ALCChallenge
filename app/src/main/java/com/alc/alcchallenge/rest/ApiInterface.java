package com.alc.alcchallenge.rest;

import com.alc.alcchallenge.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ahmed on 05/03/2017.
 * Defines an interface for the various HTTP methods we have
 *
 */

public interface ApiInterface {


    /**
     * @interface ApiInterface
     *
     * Defines a method signature to simulate the HTTP GET request with @GET annotation
     * @param type
     * @param searchTerms
     * @return
     */
    @GET("search/users")
    Call<UsersResponse> getUsers(@Query("q") String searchTerms, @Query("type") String type);
}
