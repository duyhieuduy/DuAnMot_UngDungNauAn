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
import androidx.recyclerview.widget.RecyclerView;


import com.example.cookingapp.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ThemFragment extends Fragment {
    Button btnMonCuaToi, btnMonDaLuu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.them_fragment, container, false);

        FloatingActionButton buttonThemMonMoi = view.findViewById(R.id.floatingActionButton);
        RecyclerView recyclerMonDang = view.findViewById(R.id.recyclerMonDaDang);




        buttonThemMonMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ThemMonMoiActivity.class));
            }
        });




        return view;


    }
}
