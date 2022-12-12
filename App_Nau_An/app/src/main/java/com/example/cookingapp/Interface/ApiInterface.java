package com.example.cookingapp.Interface;

import com.example.cookingapp.CallApi.nguoidungsavefs;
import com.example.cookingapp.model.Post;
import com.example.cookingapp.model.UserSave;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    Call<UserSave> senPostUserSave(@Body UserSave userSave);

    @DELETE("api/deletenguoidungsave")
    Call<UserSave> deletenusersave(@Query("mamon") int mamon, @Query("tendangnhap") String tendangnhap);

}
