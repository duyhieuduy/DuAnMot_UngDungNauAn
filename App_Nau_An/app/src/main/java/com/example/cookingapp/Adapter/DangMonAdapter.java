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

import java.util.ArrayList;

public class DangMonAdapter extends RecyclerView.Adapter<DangMonAdapter.ViewHolder>{
    private Context context;
    private ArrayList<DangBai> list;

    public DangMonAdapter(Context context, ArrayList<DangBai> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_dang_mon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txttenmon.setText(list.get(position).getTenmon());
        holder.txtloaimon.setText(list.get(position).getLoaimon());
        holder.txtthoigiannau.setText(list.get(position).getThoigiannau());
        holder.txtdokho.setText(list.get(position).getDokho());
        holder.txtnguyenlieu1.setText(list.get(position).getNguyenlieu1());
        holder.txtkhoiluong1.setText(list.get(position).getKhoiluong1());
        holder.txtnguyenlieu2.setText(list.get(position).getNguyenlieu2());
        holder.txtkhoiluong2.setText(list.get(position).getKhoiluong2());
        holder.txtnguyenlieu3.setText(list.get(position).getNguyenlieu3());
        holder.txtkhoiluong3.setText(list.get(position).getKhoiluong3());
        holder.txtnguyenlieu4.setText(list.get(position).getNguyenlieu4());
        holder.txtkhoiluong4.setText(list.get(position).getKhoiluong4());
        holder.txtcachlam.setText(list.get(position).getThoigiannau());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenmon, txtloaimon, txtthoigiannau, txtdokho,
                txtnguyenlieu1, txtkhoiluong1, txtnguyenlieu2,
                txtkhoiluong2, txtnguyenlieu3, txtkhoiluong3,
                txtnguyenlieu4, txtkhoiluong4, txtcachlam;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txttenmon = itemView.findViewById(R.id.txttenmon);
            txtloaimon = itemView.findViewById(R.id.txtloaimon);
            txtthoigiannau = itemView.findViewById(R.id.txtthoigiannau);
            txtdokho = itemView.findViewById(R.id.txtdokho);
            txtnguyenlieu1 = itemView.findViewById(R.id.txtnguyenlieu1);
            txtkhoiluong1 = itemView.findViewById(R.id.txtkhoiluong1);
            txtnguyenlieu2 = itemView.findViewById(R.id.txtnguyenlieu2);
            txtkhoiluong2 = itemView.findViewById(R.id.txtkhoiluong2);
            txtnguyenlieu3 = itemView.findViewById(R.id.txtnguyenlieu3);
            txtkhoiluong3 = itemView.findViewById(R.id.txtkhoiluong3);
            txtnguyenlieu4 = itemView.findViewById(R.id.txtnguyenlieu4);
            txtkhoiluong4 = itemView.findViewById(R.id.txtkhoiluong4);
            txtcachlam = itemView.findViewById(R.id.txtcachlam);
        }
    }
}
