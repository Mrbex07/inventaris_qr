package com.example.myapplication.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetroServer {
    private static final String baseURL = "http://10.10.10.202/inventaris9/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if(retro == null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return retro;
    }
}
