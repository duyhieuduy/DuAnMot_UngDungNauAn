package com.example.cookingapp.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cookingapp.Adapter.FoodinfoAdapter;
import com.example.cookingapp.CallApi.nguoidungdbfs;
import com.example.cookingapp.R;

import com.example.cookingapp.ThemMonMoiActivity;
import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.model.FoodInFor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class ThemFragment extends Fragment {
    RecyclerView recyclerMonDang;
    GetAllDAO getAllDAO;
    FoodinfoAdapter foodinfoAdapter;
    List<nguoidungdbfs> nguoidungdbfsList;
    ArrayList<FoodInFor> foodInForList;
    FloatingActionButton floatingActionButton;
    String tenuser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.them_fragment, container, false);



        recyclerMonDang = view.findViewById(R.id.recyclerMonDaDang);
        floatingActionButton = view.findViewById(R.id.floatingActionButton);

        SharedPreferences pref = getActivity().getSharedPreferences("USERNAME", MODE_PRIVATE);
        tenuser = pref.getString("username", "");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ThemMonMoiActivity.class));
            }
        });

        loaddatafooddang();

        return view;



    }

    private void loaddatafooddang() {
        getAllDAO= new GetAllDAO(getContext());
        nguoidungdbfsList = new ArrayList<>();
        foodInForList = new ArrayList<>();
        nguoidungdbfsList = getAllDAO.getMaMonTheoTenNguoiDungDangBai(tenuser);
        for (nguoidungdbfs s: nguoidungdbfsList) {

            foodInForList.add(getAllDAO.getAllfoodtheomamon(s.getMamon()).get(0));
        }

        foodinfoAdapter = new FoodinfoAdapter(getContext(), foodInForList);
        GridLayoutManager gridView = new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
        recyclerMonDang.setLayoutManager(gridView);
        recyclerMonDang.setAdapter(foodinfoAdapter);
    }

}