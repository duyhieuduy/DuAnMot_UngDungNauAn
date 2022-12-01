package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Interface.IFood;
import com.example.cookingapp.R;
import com.example.cookingapp.model.FoodInFor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodinfoAdapter extends RecyclerView.Adapter<FoodinfoAdapter.ViewHolder> {
    private Context context;
    private ArrayList<FoodInFor> list;
    private IFood iFood;
    public void setiFood(IFood iFood) {
        this.iFood = iFood;
    }

    public FoodinfoAdapter(Context context, ArrayList<FoodInFor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            View view = inflater.inflate(R.layout.item_foodinfo, parent, false);
            return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Picasso.get().load(list.get(position).getAnhmonlv0()).placeholder(R.drawable.img).
                    error(R.drawable.img).
                    into(holder.imgfood);
            holder.TenDs.setText(list.get(position).getTenmon());
            holder.tennl1.setText(list.get(position).getListnl().get(0).getTennguyenlieu());
            holder.tennl2.setText(list.get(position).getListnl().get(1).getTennguyenlieu());
            holder.dok.setText(list.get(position).getDokho());
            holder.thoigiannau.setText(list.get(position).getTgnau());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFood.onClickFood(list.get(position));
            }
        });


    }
        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgfood;
            TextView TenDs, tennl1, tennl2, dok, thoigiannau;
            EditText edtbl;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imgfood = itemView.findViewById(R.id.imgfood);
                TenDs = itemView.findViewById(R.id.TenDs);
                tennl1 = itemView.findViewById(R.id.tennl1);
                tennl2 = itemView.findViewById(R.id.tennl2);
                dok = itemView.findViewById(R.id.dok);
                thoigiannau = itemView.findViewById(R.id.thoigiannau);


            }

        }
    }

