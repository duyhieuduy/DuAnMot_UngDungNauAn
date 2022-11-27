package com.example.cookingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.DangMonAdapter;
import com.example.cookingapp.MonCuaToiActivity;
import com.example.cookingapp.MonDaLuuActivity;
import com.example.cookingapp.R;
import com.example.cookingapp.ThemMonMoiActivity;
import com.example.cookingapp.dao.DangBaiDAO;
import com.example.cookingapp.model.DangBai;

import java.util.ArrayList;

public class ThemFragment extends Fragment {
    Button btnMonCuaToi, btnMonDaLuu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.them_fragment, container, false);

        Button btnThemMonMoi = view.findViewById(R.id.btnThemMonMoi);
        RecyclerView recyclerMonDang = view.findViewById(R.id.recyclerMonDaDang);

        btnThemMonMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ThemMonMoiActivity.class));
            }
        });

        DangBaiDAO dangBaiDAO = new DangBaiDAO(getContext());
        ArrayList<DangBai> list = dangBaiDAO.getDSDauSach();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerMonDang.setLayoutManager(linearLayoutManager);
        DangMonAdapter adaper = new DangMonAdapter(getContext(), list);
        recyclerMonDang.setAdapter(adaper);


        return view;


    }
}
