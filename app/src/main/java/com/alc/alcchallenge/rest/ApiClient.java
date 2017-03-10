package com.alc.alcchallenge.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiClient {

    private static final String BASE_URL = "https://api.github.com";
    private static Retrofit retrofit = null;


    /**
     *
     *
     *
     * A static method to initialize the retrofit object with the base url and converter
     *
     *
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