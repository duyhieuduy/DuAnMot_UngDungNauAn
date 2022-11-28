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
import com.example.cookingapp.model.BinhLuan;

import java.util.ArrayList;

public class BinhLuanAdapter extends RecyclerView.Adapter<BinhLuanAdapter.ViewHolder>{
    private Context context;
    private ArrayList<BinhLuan> list;

    public BinhLuanAdapter(Context context, ArrayList<BinhLuan> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view  = inflater.inflate(R.layout.item_binhluan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textIDND.setText(list.get(position).getTextIDND());
        holder.binhluan.setText(list.get(position).getBinhluan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textIDND,binhluan;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textIDND =itemView.findViewById(R.id.textIDND);
            binhluan =itemView.findViewById(R.id.binhluan);

        }
    }
}
