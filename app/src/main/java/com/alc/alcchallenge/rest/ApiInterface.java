package com.alc.alcchallenge.rest;

import com.alc.alcchallenge.model.GitHubUsers;

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
     *
     *
     * Defines a method signature to simulate the HTTP GET request with @GET annotation
     * @params type
     * @params searchTerms
     *
     */
    @GET("/search/users")
    Call<GitHubUsers> getUsers(@Query("q") String searchTerms, @Query("type") String type, @Query("per_page") String itemsPerPage, @Query("access_token") String accessToken);
}
