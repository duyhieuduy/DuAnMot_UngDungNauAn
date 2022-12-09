package com.example.cookingapp;

import static com.example.cookingapp.CallApi.ApiService.BASE_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cookingapp.CallApi.ApiService;
import com.example.cookingapp.CallApi.getalluser;
import com.example.cookingapp.dao.InsertDao;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    InsertDao insertDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertDao = new InsertDao(MainActivity.this);
        getListgetalluser();


        Button btnlogin = findViewById(R.id.btnlogin);
        Button btnregis = findViewById(R.id.btnregister);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login_Activity.class);
                startActivity(intent);
            }
        });
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Register_Activity.class);
                startActivity(intent);
                //test
            }
        });
    }

    private void getListgetalluser() {
        ApiService requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);

        new CompositeDisposable().add(requestInterface.getListgetalluser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }


    private void handleResponse(ArrayList<getalluser> getallusers) {
        for (getalluser getallusersa : getallusers) {
            insertDao.insertNGUOIDUNG(
                    getallusersa.getTendangnhap(),
                    getallusersa.getMatkhau(),
                    getallusersa.getSdt(),
                    getallusersa.getEmail(),
                    getallusersa.getDiachi(),
                    getallusersa.getTuoi());
        }
    }

    private void handleError(Throwable error) {
        Log.d("CALL LOI",")()())()()(" + error);
        Toast.makeText(MainActivity.this, "Call Fail  " + error, Toast.LENGTH_LONG).show();
    }


}