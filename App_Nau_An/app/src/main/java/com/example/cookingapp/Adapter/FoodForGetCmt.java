package com.example.cookingapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< Updated upstream
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
=======
>>>>>>> Stashed changes

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.R;
<<<<<<< Updated upstream
import com.example.cookingapp.model.FoodInFor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodForGetCmt extends RecyclerView.Adapter<FoodForGetCmt.ViewHloder> {
    private Context context;
    private ArrayList<FoodInFor> list;

    public FoodForGetCmt(Context context, ArrayList<FoodInFor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_foodinforgetbl,parent,false);
=======

public class FoodForGetCmt extends RecyclerView.Adapter<FoodForGetCmt.ViewHloder>{
    private Context context;
    @NonNull
    @Override
    public ViewHloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_foodinforgetbl,parent,false);

>>>>>>> Stashed changes
        return new ViewHloder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHloder holder, int position) {
<<<<<<< Updated upstream
        Picasso.with(context.getApplicationContext()).load(list.get(position).getImgfood()).placeholder(R.drawable.img).
                error(R.drawable.img).
                into(holder.imgfood);
        holder.TenDs.setText(list.get(position).getTenDs());
        holder.tennl1.setText(list.get(position).getTennl1());
        holder.tennl2.setText(list.get(position).getTennl2());
        holder.dok.setText(list.get(position).getDok());
        holder.thoigiannau.setText(list.get(position).getThoigiannau());
        holder.container.setVisibility(View.INVISIBLE);
        holder.edtbl.setText(list.get(position).getEdtbl());

        holder.btnxoxuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.container.setVisibility(View.VISIBLE);

            }
        });

        holder.btnaddbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.btnaddbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
=======
>>>>>>> Stashed changes

    }

    @Override
    public int getItemCount() {
<<<<<<< Updated upstream
        return list.size();
    }


=======
        return 0;
    }

>>>>>>> Stashed changes
    public class ViewHloder extends RecyclerView.ViewHolder{

        ImageView imgfood,btnaddbl;
        TextView TenDs,tennl1,tennl2,dok,thoigiannau;
        EditText edtbl;
        Button btnxoxuong;
        FrameLayout container;

        public ViewHloder(@NonNull View itemView) {
            super(itemView);
            imgfood = itemView.findViewById(R.id.imgfood);
            TenDs = itemView.findViewById(R.id.TenDs);
            tennl1 =itemView.findViewById(R.id.tennl1);
            tennl2 =itemView.findViewById(R.id.tennl2);
            dok = itemView.findViewById(R.id.dok);
            thoigiannau = itemView.findViewById(R.id.thoigiannau);
            //trong model kco
            btnxoxuong = itemView.findViewById(R.id.btnxoxuong);
            btnaddbl = itemView.findViewById(R.id.btnaddbl);
            edtbl = itemView.findViewById(R.id.edtbl);
            container = itemView.findViewById(R.id.container);

        }
    }
}
