package com.example.cookingapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.LMAdapter;

import com.example.cookingapp.Interface.ILM;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.GetAllDAO;

import com.example.cookingapp.model.LOAIMONmodel;


import java.util.ArrayList;

public class LoaiMonFragment extends Fragment {
    RecyclerView lvloaimon;
    ArrayList<LOAIMONmodel> listloaimon;
    GetAllDAO getAllDAO;
    LMAdapter lmAdapter;
    TextView tvtatca;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loaimoncontener, container, false);
        lvloaimon = view.findViewById(R.id.recycLoaiMon);
        tvtatca = view.findViewById(R.id.tvtatca);
        tvtatca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        loaddataLoaiMon();

      lmAdapter.setIlm(new ILM() {
          @Override
          public void OnclickLM(LOAIMONmodel loaimoNmodel) {

              Toast.makeText(getActivity(), ""+loaimoNmodel.getMaloai(), Toast.LENGTH_SHORT).show();
          }
      });
        return view;
    }
    void loaddataLoaiMon() {
        listloaimon = new ArrayList<>();
        getAllDAO = new GetAllDAO(getContext());
        listloaimon = getAllDAO.getAlllm();
        LinearLayoutManager linearLayoutManagera = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        lvloaimon.setLayoutManager(linearLayoutManagera);
        lmAdapter = new LMAdapter(getContext(),listloaimon);
        lvloaimon.setAdapter(lmAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
