package com.example.cookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cookingapp.Adapter.BinhluanAdapter;
import com.example.cookingapp.Adapter.SearchAdapter;
import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.model.BinhLuan;
import com.example.cookingapp.model.CLAnhMonAn;
import com.example.cookingapp.model.FooddetailModel;
import com.example.cookingapp.model.NguyenLieu;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class CTNLActivity extends AppCompatActivity {
    GetAllDAO congThucNguyenLieuDAO;
    ArrayList<FooddetailModel>  list;
    ArrayList<CLAnhMonAn>  listama;
    ArrayList<BinhLuan>  listbl;
    ArrayList<NguyenLieu>  listnl;
    RecyclerView rvbinhluan;
    TextView MOXT,GT,textTG,TennL1,TennL2,ctcl;
    ImageView imgCTNL,imgcl1,imgcl2,imgcl3;
    BinhluanAdapter binhluanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctnl);
        list = new ArrayList<>();
        listama = new ArrayList<>();
        listbl = new ArrayList<>();
        listnl = new ArrayList<>();
        rvbinhluan = findViewById(R.id.rvbinhluan);
        congThucNguyenLieuDAO = new GetAllDAO(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("key1",0);
        list = congThucNguyenLieuDAO.getClickItemIDmon(id);

        imgCTNL = findViewById(R.id.imgCTNL);
        imgcl1 = findViewById(R.id.imgcl1);
        imgcl2 = findViewById(R.id.imgcl2);
        imgcl3 = findViewById(R.id.imgcl3);


        MOXT = findViewById(R.id.MOXT);
        GT = findViewById(R.id.GT);
        textTG = findViewById(R.id.textTG);
        TennL1 = findViewById(R.id.TennL1);
        TennL2 = findViewById(R.id.TennL2);
        ctcl = findViewById(R.id.ctcl);


        MOXT.setText(list.get(0).getTenmon());
        GT.setText(list.get(0).getCongthuclam());
        textTG.setText(list.get(0).getTgnau());

        listnl = list.get(0).getListb();
        TennL1.setText(" "+listnl.get(0).getTennguyenlieu());
        TennL2.setText(", "+listnl.get(1).getTennguyenlieu());
        ctcl.setText(list.get(0).getCachlam());

        listama = list.get(0).getList();
        Picasso.get().load(list.get(0).getAnhmon()).
               into(imgCTNL);
        Picasso.get().load(listama.get(0).getAnhmonan()).
                into(imgcl1);
        Picasso.get().load(listama.get(1).getAnhmonan()).
                into(imgcl2);
        Picasso.get().load(listama.get(2).getAnhmonan()).
                into(imgcl3);



        listbl = list.get(0).getLista();
        Toast.makeText(this, "ndbl"+listbl.get(1).getNoidungbinhluan() +"ten"+ listbl.get(1).getTendangnhap()+"/n" +
                        ""+"ndbl"+listbl.get(0).getNoidungbinhluan() +"ten"+ listbl.get(0).getTendangnhap()
                , Toast.LENGTH_LONG).show();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CTNLActivity.this);
        rvbinhluan.setLayoutManager(linearLayoutManager);
        binhluanAdapter = new BinhluanAdapter(CTNLActivity.this,listbl);
        rvbinhluan.setAdapter(binhluanAdapter);

    }
}