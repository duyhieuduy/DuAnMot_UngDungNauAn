package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    public SearchAdapter(Context context, List<FoodInFor> mListFood, List<FoodInFor> mListFoodOld) {
        this.context = context;
        this.mListFood = mListFood;
        this.mListFoodOld = mListFoodOld;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_foodinforgetbl, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.with(context.getApplicationContext()).load(mListFoodOld.get(position).getAnhmonlv0()).placeholder(R.drawable.img).
                error(R.drawable.img).
                into(holder.imgfood);
        holder.TenDs.setText(mListFoodOld.get(position).getTenmon());
        holder.tennl1.setText(mListFoodOld.get(position).getListnl().get(0).getTennguyenlieu());
        holder.tennl2.setText(mListFoodOld.get(position).getListnl().get(1).getTennguyenlieu());
        holder.dok.setText(mListFoodOld.get(position).getDokho());
        holder.thoigiannau.setText(mListFoodOld.get(position).getTgnau());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFood.onClickFood(mListFoodOld.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListFoodOld.size();
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
    TextView TenDs, tennl1, tennl2, dok, thoigiannau;
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
