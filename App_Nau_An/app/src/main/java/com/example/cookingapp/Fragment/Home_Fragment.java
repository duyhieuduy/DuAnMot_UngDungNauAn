package com.example.cookingapp.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.LoaiMonAdapter;
import com.example.cookingapp.Adapter.MonAnAdapter;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.LoaiMonDAO;
import com.example.cookingapp.dao.MonAnDAO;
import com.example.cookingapp.model.LoaiMon;
import com.example.cookingapp.model.MonAn;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        RecyclerView recyclerMonAn = view.findViewById(R.id.recyclerMonAn);

        LoaiMonDAO loaiMonDAO = new LoaiMonDAO(getContext());


        ArrayList<LoaiMon> list = loaiMonDAO.getDSLoaiMon();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerMonAn.setLayoutManager(linearLayoutManager);
        LoaiMonAdapter adapter = new LoaiMonAdapter(getContext(), list);
        recyclerMonAn.setAdapter(adapter);



        return view;
    }

}