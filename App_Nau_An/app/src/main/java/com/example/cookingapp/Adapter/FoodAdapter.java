package com.example.cookingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.CallApi.Food;
import com.example.cookingapp.R;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    private List<Food> mList;

    public FoodAdapter(List<Food> mList) {
        this.mList = mList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = mList.get(position);
        if (food == null){
            return;
        }
        holder.txtmamon.setText(String.valueOf(food.getMamon()));
        holder.txtmaloai.setText(String.valueOf(food.getMaloai()));
        holder.txttenloai.setText(String.valueOf(food.getTenloai()));
        holder.txttenmon.setText(String.valueOf(food.getTenmon()));
    }

    @Override
    public int getItemCount() {
        if (mList != null){
            return mList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtmamon, txtmaloai, txttenloai, txttenmon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtmamon = itemView.findViewById(R.id.txtmamon);
            txtmaloai = itemView.findViewById(R.id.txtmaloai);
            txttenloai = itemView.findViewById(R.id.txttenloai);
            txttenmon = itemView.findViewById(R.id.txttenmon);
        }
    }
}
