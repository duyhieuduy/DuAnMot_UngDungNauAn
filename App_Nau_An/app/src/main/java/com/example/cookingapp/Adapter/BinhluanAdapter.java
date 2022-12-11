package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Interface.ILM;
import com.example.cookingapp.R;
import com.example.cookingapp.model.BinhLuan;
import com.example.cookingapp.model.LOAIMONmodel;

import java.util.ArrayList;

    public class BinhluanAdapter extends RecyclerView.Adapter<com.example.cookingapp.Adapter.BinhluanAdapter.ViewHolder>{
        private Context context;
        private ArrayList<BinhLuan> list;
        public BinhluanAdapter(Context context, ArrayList<BinhLuan> list) {
            this.context = context;
            this.list = list;
        }
        @NonNull
        @Override
        public com.example.cookingapp.Adapter.BinhluanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            View view = inflater.inflate(R.layout.item_binhluan, parent, false);

            return new com.example.cookingapp.Adapter.BinhluanAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.cookingapp.Adapter.BinhluanAdapter.ViewHolder holder, int position) {

            if (list.get(position).getTendangnhap() != null)
            {
                holder.tendangnhap.setText(list.get(position).getTendangnhap());

            }
            if (list.get(position).getNoidungbinhluan() != null){
                holder.binhluan.setText(list.get(position).getNoidungbinhluan());
            }
        }
        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView tendangnhap,binhluan;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tendangnhap = itemView.findViewById(R.id.tendangnhap);
                binhluan = itemView.findViewById(R.id.binhluan);

            }
        }
    }


