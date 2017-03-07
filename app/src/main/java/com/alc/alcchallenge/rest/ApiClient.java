package com.alc.alcchallenge.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahmed on 05/03/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://www.api.github.com";
    private static Retrofit retrofit = null;


    /**
     * @class ApiClient
     *
     *
     * A static method to initialize the retrofit object with the base url and converter
     *
     * @method getClient
     *
     * @return Retrofit object
     */
    public static Retrofit getClient(){

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}