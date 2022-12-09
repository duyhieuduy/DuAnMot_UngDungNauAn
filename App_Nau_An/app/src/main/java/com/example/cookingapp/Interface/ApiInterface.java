package com.example.cookingapp.Interface;

import com.example.cookingapp.model.Post;
import com.example.cookingapp.model.Register;
import com.example.cookingapp.model.UserSave;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    ApiInterface apiInterface = new Retrofit.Builder()
            .baseUrl("https://hieupro.kynalab.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiInterface.class);

    // post mondang
    @POST("/api/addall")
    Call<Post> sendPosts(@Body Post post);

    // post user save
    @POST("api/adnds")
    Call<Number> senPostUserSave(@Body UserSave userSave);

}
