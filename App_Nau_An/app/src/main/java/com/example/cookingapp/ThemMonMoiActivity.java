package com.example.cookingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cookingapp.Fragment.ThemFragment;

public class ThemMonMoiActivity extends AppCompatActivity {
    ImageView imgAnhMon, imgAnhCachLam1, imgAnhCachLam2, imgAnhCachLam3;
    Button btnThayDoiAnh, btnLuu, btnLenSong;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mon_moi);
        btnThayDoiAnh =  findViewById(R.id.btnThaydoiAnh);
        imgAnhMon = findViewById(R.id.imgAnhMon);
        imgAnhCachLam1 = findViewById(R.id.imgAnhCachLam1);
        imgAnhCachLam2 = findViewById(R.id.imgAnhCachLam2);
        imgAnhCachLam3 = findViewById(R.id.imgAnhCachLam3);



        btnThayDoiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        imgAnhCachLam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, 2);
            }
        });
        imgAnhCachLam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent2, 3);
            }
        });
        imgAnhCachLam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent3, 4);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            uri = data.getData();
            imgAnhMon.setImageURI(uri);
            imgAnhCachLam1.setImageURI(uri);
            imgAnhCachLam2.setImageURI(uri);
            imgAnhCachLam3.setImageURI(uri);
        }
    }
}