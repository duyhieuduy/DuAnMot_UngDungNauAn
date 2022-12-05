package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cookingapp.Interface.ApiInterface;
import com.example.cookingapp.model.UserSave;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiUserSaveActivity extends AppCompatActivity {
    private Button btnSendPostsUserSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_user_save);

        btnSendPostsUserSave = findViewById(R.id.btnSendPostsUserSave);
        btnSendPostsUserSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPostsUserSave();
            }
        });
    }

    private void sendPostsUserSave() {
        UserSave userSave = new UserSave("HieuPham", 1);
        ApiInterface.apiInterface.sendPostsUserSave(userSave).enqueue(new Callback<UserSave>() {
            @Override
            public void onResponse(Call<UserSave> call, Response<UserSave> response) {
                Toast.makeText(ApiUserSaveActivity.this, "Call Api Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserSave> call, Throwable t) {
                Toast.makeText(ApiUserSaveActivity.this, "Call Api Success", Toast.LENGTH_SHORT).show();

            }
        });
    }
}