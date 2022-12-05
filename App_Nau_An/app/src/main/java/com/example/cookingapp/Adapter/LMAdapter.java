package com.example.cookingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cookingapp.R;
import com.example.cookingapp.model.LOAIMONmodel;

import java.util.List;

public class LMAdapter extends RecyclerView.Adapter<LMAdapter.ViewHolder>{
    private List<LOAIMONmodel> mList;

    public LMAdapter(List<LOAIMONmodel> mList) {
        this.mList = mList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LOAIMONmodel food = mList.get(position);
        if (food == null){
            return;
        }
        holder.txttenloai.setText(String.valueOf(food.getTenloai()));
    }

    @Override
    public int getItemCount() {
        if (mList != null){
            return mList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenloai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txttenloai = itemView.findViewById(R.id.textview);

        }
    }
}
