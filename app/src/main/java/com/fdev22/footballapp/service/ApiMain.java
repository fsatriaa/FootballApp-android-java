package com.fdev22.footballapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public FootballRepository getApiFootball(){
        String BASE_URL = "https://www.thesportsdb.com/api/v1/json/";
        if (retrofit == null){
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FootballRepository.class);
    }
}
