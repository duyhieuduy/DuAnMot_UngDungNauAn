package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.R;
import com.example.cookingapp.model.LoaiMon;
import com.example.cookingapp.model.MonAn;

import java.util.ArrayList;

public class LoaiMonAdapter extends RecyclerView.Adapter<LoaiMonAdapter.ViewHolder>{
    private Context context;
    private ArrayList<LoaiMon> list;

    public LoaiMonAdapter(Context context, ArrayList<LoaiMon> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaimon, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTenLoai.setText(list.get(position).getTenloai());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtTenLoai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTenLoai = itemView.findViewById(R.id.txtTenLoai);
        }
    }
}
