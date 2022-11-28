package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Fragment.Home_Fragment;
import com.example.cookingapp.R;
import com.example.cookingapp.model.NewNguyenLieu;
import com.example.cookingapp.model.NguyenLieu;
import com.example.cookingapp.model.dao;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NguyenLieuAdapter extends RecyclerView.Adapter<NguyenLieuAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NguyenLieu> list;
    List<CardView>cardViewList = new ArrayList<>();
    dao daoz;
    private ItemClickListener mClickListener;


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
        Picasso.with(context.getApplicationContext()).load(list.get(position).getAnhnguyenlieu()).placeholder(R.drawable.img).
                error(R.drawable.img).
                into(holder.img);

        if (!cardViewList.contains(holder.cardView)) {
            cardViewList.add(holder.cardView);
        }        for(CardView cardView : cardViewList){
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.teal_200));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, "XNXX", Toast.LENGTH_SHORT).show();
                daoz.insert(list.get(position).getManguyenlieu(),list.get(position).getTennguyenlieu(),list.get(position).getAnhnguyenlieu());
                //The selected card is set to colorSelected
                holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorSelected));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public Object getItem(int position) {
       return list.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView text;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
            cardView = itemView.findViewById(R.id.cardviewnl);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }



}
