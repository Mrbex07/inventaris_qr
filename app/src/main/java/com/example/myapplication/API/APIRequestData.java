package com.example.myapplication.API;

import com.example.myapplication.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
public interface APIRequestData {
    @GET("retrive.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("get.php")
    Call<ResponseModel> ardGetData(
            @Field("id") int id
    );
}
