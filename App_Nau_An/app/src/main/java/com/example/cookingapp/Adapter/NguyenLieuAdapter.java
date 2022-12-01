package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cookingapp.Interface.INguyenLieu;

import com.example.cookingapp.Fragment.Home_Fragment;

import com.example.cookingapp.R;
import com.example.cookingapp.model.NguyenLieu;
import com.example.cookingapp.dao.dao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NguyenLieuAdapter extends RecyclerView.Adapter<NguyenLieuAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NguyenLieu> list;
    List<CardView>cardViewList = new ArrayList<>();
    dao daoz;
    private INguyenLieu iNguyenLieu;

    public void setiNguyenLieu(INguyenLieu iNguyenLieu) {
        this.iNguyenLieu = iNguyenLieu;
    }
    public NguyenLieuAdapter(Context context, ArrayList<NguyenLieu> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_nguyenlieu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        daoz = new dao(context);
        holder.text.setText("" + list.get(position).getTennguyenlieu());
        Picasso.get().load(list.get(position).getAnhnguyenlieu()).placeholder(R.drawable.img).
                error(R.drawable.img).
                into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNguyenLieu.onClick(list.get(position));
            }
        });

        if (!cardViewList.contains(holder.cardView)) {
            cardViewList.add(holder.cardView);
        }        for(CardView cardView : cardViewList){
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.teal_200));
        }

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorSelected));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Object getItem(int position) {
       return list.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView text;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
            cardView = itemView.findViewById(R.id.cardviewnl);


        }

    }



}
