package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.R;
import com.example.cookingapp.model.DangBai;

import java.util.ArrayList;

public class DangBaiAdapter extends RecyclerView.Adapter<DangBaiAdapter.ViewHolder>{
    private Context context;
    private ArrayList<DangBai> list;

    public DangBaiAdapter(Context context, ArrayList<DangBai> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_dang_mon, parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_anhmon, iv_anhcachlam1, iv_anhcachlam2, iv_anhcachlam3;
        TextView tenmon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_anhmon = itemView.findViewById(R.id.iv_anhmon);
        }
    }
}
