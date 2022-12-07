package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cookingapp.Fragment.ShowFoodtFragment;
import com.example.cookingapp.Fragment.WaitFragment;
import com.example.cookingapp.Interface.ILM;
import com.example.cookingapp.R;
import com.example.cookingapp.model.LOAIMONmodel;

import java.util.ArrayList;

public class LMAdapter extends RecyclerView.Adapter<LMAdapter.ViewHolder>{
    private Context context;
    private ArrayList<LOAIMONmodel> list;
    private ILM ilm;
    public void setIlm(ILM ilm) {
        this.ilm = ilm;
    }

    public LMAdapter(Context context, ArrayList<LOAIMONmodel> list) {
        this.context = context;
        this.list = list;
    }

    



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_lm, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.txttenloai.setText(String.valueOf(list.get(position).getTenloai()));
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ilm.OnclickLM(list.get(position));
//               AppCompatActivity activity = (AppCompatActivity) view.getContext();
//               Bundle bun = new Bundle();
//               bun.putInt("maloai",-1);
//               showFoodtFragment.setArguments(bun);
//               showFoodtFragment = new ShowFoodtFragment();
//              FragmentManager fragmentManager = activity.getSupportFragmentManager();
//              fragmentManager.beginTransaction()
//                      .replace(R.id.rec,showFoodtFragment).addToBackStack(null).commit();
           }
       });



    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttenloai,textviewid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenloai = itemView.findViewById(R.id.textview);

        }
    }
}
