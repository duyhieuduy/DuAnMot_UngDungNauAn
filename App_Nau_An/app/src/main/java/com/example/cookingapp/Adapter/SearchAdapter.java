package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.CTNLActivity;
import com.example.cookingapp.Interface.IFood;
import com.example.cookingapp.R;
import com.example.cookingapp.model.FoodInFor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> implements Filterable {
    private Context context;
    private List<FoodInFor> mListFood;
    private List<FoodInFor> mListFoodOld;
    private IFood iFood;

    public void setiFood(IFood iFood) {
        this.iFood = iFood;
    }

    public SearchAdapter(Context context, List<FoodInFor> mListFood) {
        this.context = context;
        this.mListFood = mListFood;
        this.mListFoodOld = mListFood;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_search, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mListFood.get(position) == null){
            return;
        }
        Picasso.get().load(mListFood.get(position).getAnhmonlv0()).placeholder(R.drawable.anhdangmon).
                error(R.drawable.anhdangmon).
                into(holder.imgfood);
        holder.TenDs.setText(mListFood.get(position).getTenmon());
        if (mListFood.get(position).getListnl().size()>0) {
            holder.tennl1.setText(mListFood.get(position).getListnl().get(0).getTennguyenlieu());
        }

        if (mListFood.get(position).getListnl().size()>1) {
            holder.tennl2.setText(" ,"+mListFood.get(position).getListnl().get(1).getTennguyenlieu());
        }
        else {
            holder.tennl2.setVisibility(View.GONE);
        }
        if (mListFood.get(position).getListnl().size()>2) {
            holder.tennl3.setText(" ,"+mListFood.get(position).getListnl().get(2).getTennguyenlieu());
        }
        else {
            holder.tennl3.setVisibility(View.GONE);
        }
        if (mListFood.get(position).getListnl().size()>3){
            holder.tennl4.setText(" ,"+mListFood.get(position).getListnl().get(3).getTennguyenlieu());
        }
        else {
            holder.tennl4.setVisibility(View.GONE);
        }
        holder.dok.setText(mListFood.get(position).getDokho());
        holder.thoigiannau.setText(mListFood.get(position).getTgnau());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFood.onClickFood(mListFoodOld.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {

        if (mListFood != null){
            return mListFood.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()){
                    mListFood = mListFoodOld;
                } else {
                    List<FoodInFor> list = new ArrayList<>();
                    for (FoodInFor food : mListFoodOld){
                        if (food.getTenmon().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(food);
                        }
                    }

                    mListFood = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListFood;
                return filterResults;
            }


            @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mListFood = (List<FoodInFor>) results.values;
        notifyDataSetChanged();
    }
};
}




public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imgfood;
    TextView TenDs, tennl1, tennl2,tennl3,tennl4, dok, thoigiannau;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                imgfood = itemView.findViewById(R.id.imgfood);
                TenDs = itemView.findViewById(R.id.TenDs);
                tennl1 = itemView.findViewById(R.id.tennl1);
                tennl2 = itemView.findViewById(R.id.tennl2);
                tennl3 = itemView.findViewById(R.id.tennl3);
                tennl4 = itemView.findViewById(R.id.tennl4);
                dok = itemView.findViewById(R.id.dok);
                thoigiannau = itemView.findViewById(R.id.thoigiannau);

            }
        }

}
