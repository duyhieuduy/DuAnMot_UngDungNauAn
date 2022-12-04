package com.example.cookingapp.CallApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    public String BASE_Service = "https://hieupro.kynalab.com/";

    @GET("api/GetFood")
    Observable<ArrayList<Food>> getListFood();
}
