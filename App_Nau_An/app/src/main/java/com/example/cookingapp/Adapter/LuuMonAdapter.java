package com.example.cookingapp.Adapter;

import static android.content.Context.MODE_PRIVATE;
import static com.example.cookingapp.CallApi.ApiService.BASE_Service;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.CallApi.ApiService;
import com.example.cookingapp.CallApi.nguoidungsavefs;
import com.example.cookingapp.Interface.ApiInterface;
import com.example.cookingapp.Interface.IFood;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.model.FoodInFor;
import com.example.cookingapp.model.UserSave;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LuuMonAdapter extends RecyclerView.Adapter<LuuMonAdapter.ViewHolder> implements Filterable {
    private Context context;
    private List<FoodInFor> mListFood;
    private List<FoodInFor> mListFoodOld;
    private IFood iFood;
    private GetAllDAO getAllDAO;
    private List<nguoidungsavefs> nguoidungsavefsArrayList;
    private nguoidungsavefs nguoidungsavefs;


    public void setiFood(IFood iFood) {
        this.iFood = iFood;
    }

    public LuuMonAdapter(Context context, List<FoodInFor> mListFood) {
        this.context = context;
        this.mListFood = mListFood;
        this.mListFoodOld = mListFood;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_luu_mon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mListFood.get(position) == null) {
            return;
        }
        Picasso.get().load(mListFood.get(position).getAnhmonlv0()).placeholder(R.drawable.anhdangmon).
                error(R.drawable.anhdangmon).
                into(holder.imgfood);
        holder.TenDs.setText(mListFood.get(position).getTenmon());
        if (mListFood.get(position).getListnl().size() > 0) {
            holder.tennl1.setText(mListFood.get(position).getListnl().get(0).getTennguyenlieu());
        }

        if (mListFood.get(position).getListnl().size() > 1) {
            holder.tennl2.setText(" ," + mListFood.get(position).getListnl().get(1).getTennguyenlieu());
        } else {
            holder.tennl2.setVisibility(View.GONE);
        }
        if (mListFood.get(position).getListnl().size() > 2) {
            holder.tennl3.setText(" ," + mListFood.get(position).getListnl().get(2).getTennguyenlieu());
        } else {
            holder.tennl3.setVisibility(View.GONE);
        }
        if (mListFood.get(position).getListnl().size() > 3) {
            holder.tennl4.setText(" ," + mListFood.get(position).getListnl().get(3).getTennguyenlieu());
        } else {
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

        holder.btnboluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog_deleteMonLuu(position);
            }
        });

    }
    private void openDialog_deleteMonLuu(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.setMessage("Bạn có muốn bỏ lưu không ? ");
        builder.setCancelable(false);
        builder.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                SharedPreferences pref = context.getSharedPreferences("USERNAME", MODE_PRIVATE);
                String tenuser = pref.getString("username", "");

                int mamon = mListFood.get(position).getMamon();
                SharedPreferences pref1 = context.getSharedPreferences("MAMON", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref1.edit();
                editor.putString("mamon", String.valueOf(mamon));
                editor.commit();

                getAllDAO = new GetAllDAO(builder.getContext());
                nguoidungsavefsArrayList = new ArrayList<>();
                nguoidungsavefsArrayList = getAllDAO.getIdtheomamonvstennguoidung( tenuser);
                int id = nguoidungsavefsArrayList.get(position).getIdnds();




                ApiService requestInterface = new Retrofit.Builder()
                        .baseUrl(BASE_Service)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(ApiService.class);
                new CompositeDisposable().add(requestInterface.deletenguoidungsave(id)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, this::handleError)
                );
                ProgressDialog progressDialog = ProgressDialog.show(context, "Loading...", "Please wait...", true);
                progressDialog.setCancelable(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }).start();



            }

            private void handleResponse(UserSave userSave) {

            }
            private void handleError(Throwable error){

            }

        }).show();


    }






    @Override
    public int getItemCount() {

        if (mListFood != null) {
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
                if (strSearch.isEmpty()) {
                    mListFood = mListFoodOld;
                } else {
                    List<FoodInFor> list = new ArrayList<>();
                    for (FoodInFor food : mListFoodOld) {
                        if (food.getTenmon().toLowerCase().contains(strSearch.toLowerCase())) {
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


    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton btnboluu;
        ImageView imgfood;
        TextView TenDs, tennl1, tennl2, tennl3, tennl4, dok, thoigiannau;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgfood = itemView.findViewById(R.id.imgfoodluumon);
            TenDs = itemView.findViewById(R.id.TenDsluumon);
            tennl1 = itemView.findViewById(R.id.tennl1luumon);
            tennl2 = itemView.findViewById(R.id.tennl2luumon);
            tennl3 = itemView.findViewById(R.id.tennl3luumon);
            tennl4 = itemView.findViewById(R.id.tennl4luumon);
            dok = itemView.findViewById(R.id.dokluumon);
            thoigiannau = itemView.findViewById(R.id.txtthoigiannauluumon);

            btnboluu = itemView.findViewById(R.id.btnboluu);

        }
    }

}
