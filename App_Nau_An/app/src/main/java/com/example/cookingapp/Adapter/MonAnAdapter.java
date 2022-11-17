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
import com.example.cookingapp.model.MonAn;

import java.util.ArrayList;

public class MonAnAdapter extends RecyclerView.Adapter<MonAnAdapter.ViewHolder>{
    private Context context;
    private ArrayList<MonAn> list;

    public MonAnAdapter(Context context, ArrayList<MonAn> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_mon_an, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtMaMon.setText("Mã món: " + list.get(position).getMamon());
        holder.txtMaLoai.setText("Mã loại: " + list.get(position).getMaloai());
        holder.txtTenMon.setText("Tên món: " + list.get(position).getTenmon());
        holder.txtCongThucLam.setText("Công thức làm: " + list.get(position).getCongthuclam());
        holder.txtThoiGianNau.setText("Thời gian nấu: " + list.get(position).getThoigiannau());
        holder.txtDoKho.setText("Độ khó: " + list.get(position).getDokho());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtMaMon, txtMaLoai, txtTenMon, txtCongThucLam, txtThoiGianNau, txtDoKho;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtMaMon = itemView.findViewById(R.id.txtMaMon);
            txtMaLoai = itemView.findViewById(R.id.txtMaLoai);
            txtTenMon = itemView.findViewById(R.id.txtTenMon);
            txtCongThucLam = itemView.findViewById(R.id.txtCongThucLam);
            txtThoiGianNau = itemView.findViewById(R.id.txtThoiGianNau);
            txtDoKho = itemView.findViewById(R.id.txtDoKho);
        }
    }

}
