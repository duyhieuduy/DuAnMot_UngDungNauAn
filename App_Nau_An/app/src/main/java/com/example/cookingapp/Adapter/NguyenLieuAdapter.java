package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.DrawableUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.R;
import com.example.cookingapp.model.Nguyenlieu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NguyenLieuAdapter extends RecyclerView.Adapter<NguyenLieuAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Nguyenlieu> list;

    public NguyenLieuAdapter(Context context, ArrayList<Nguyenlieu> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater  = ((Activity)context).getLayoutInflater();
        View view =inflater.inflate(R.layout.item_nguyenlieu,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setText(""+list.get(position).getTenNL());
        Picasso.with(context.getApplicationContext()).load(list.get(position).getAnhnguyenlieu()).placeholder(R.drawable.img).
                error(R.drawable.img).
                into(holder.img);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        img = itemView.findViewById(R.id.img);
        text = itemView.findViewById(R.id.text);


        }
    }
}
