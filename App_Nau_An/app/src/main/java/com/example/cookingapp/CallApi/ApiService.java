package com.example.cookingapp.CallApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyy").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://hieupro.kynalab.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("api/GetFood")
    Call<List<Food>> getListUsers(@Query("mamon") int mamon);
}
