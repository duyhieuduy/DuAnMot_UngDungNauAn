package com.example.cookingapp.CallApi;

import com.example.cookingapp.model.Register;
import com.example.cookingapp.model.UserSave;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    public String BASE_Service = "https://hieupro.kynalab.com/";

    @GET("api/GetFood")
    Observable<ArrayList<Food>> getListFood();
    @GET("api/Getalluser")
    Observable<ArrayList<getalluser>> getListgetalluser();

    @GET("api/updateuser")
    Observable<Number> updateuser();


    @POST("api/deletemondadang")
    Observable<Number> deletemondadang();


    @DELETE("api/deletenguoidungsave")
    Observable<UserSave> deletenguoidungsave(@Query("id") int id);


    @POST("api/adduser")
    Observable<Number> sendPost(@Body Register register);
    // post user save
    @POST("api/adnds")
    Observable<Number> senPostUserSave(@Body UserSave userSave);
}
