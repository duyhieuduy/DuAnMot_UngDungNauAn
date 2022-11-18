package com.example.cookingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cookingapp.Fragment.ThemFragment;

public class ThemMonMoiActivity extends AppCompatActivity {
    ImageView imgAnhMon, imgAnhCachLam;
    Button btnThayDoiAnh, btnLuu, btnLenSong;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mon_moi);
        btnThayDoiAnh = findViewById(R.id.btnThaydoiAnh);
        imgAnhMon = findViewById(R.id.imgAnhMon);
        imgAnhCachLam = findViewById(R.id.imgAnhCachLam);





        btnThayDoiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);

            }
        });
        imgAnhCachLam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, 3);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            uri = data.getData();
            imgAnhMon.setImageURI(uri);
            imgAnhCachLam.setImageURI(uri);


    }
}