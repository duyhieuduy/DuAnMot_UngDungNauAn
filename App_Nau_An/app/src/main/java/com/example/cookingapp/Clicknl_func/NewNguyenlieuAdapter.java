package com.example.cookingapp.Clicknl_func;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewNguyenlieuAdapter extends RecyclerView.Adapter<NewNguyenlieuAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NewNguyenLieu> list;



    public NewNguyenlieuAdapter(Context context, ArrayList<NewNguyenLieu> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_newnguyenlieu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setText("" + list.get(position).getTennguyenlieu());


        holder.iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao loaiSachDAO = new dao(context);
                boolean check = loaiSachDAO.xoaNguyenLieu(list.get(holder.getAdapterPosition()).getTennguyenlieu());

                if(check){
                    list.clear();
                    list = loaiSachDAO.getall();
                    notifyDataSetChanged();
                    Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context, "Xóa không thành công", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img,iv_delete;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            text = itemView.findViewById(R.id.text);
            iv_delete = itemView.findViewById(R.id.iv_delete);
        }
    }
}
