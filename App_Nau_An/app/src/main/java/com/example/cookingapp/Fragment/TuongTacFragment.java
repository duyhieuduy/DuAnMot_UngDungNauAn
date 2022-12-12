package com.example.cookingapp.Fragment;

import static android.content.Context.MODE_PRIVATE;

import static com.example.cookingapp.CallApi.ApiService.BASE_Service;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.FoodinfoAdapter;
import com.example.cookingapp.Adapter.LuuMonAdapter;
import com.example.cookingapp.CTNLActivity;
import com.example.cookingapp.CallApi.ApiService;
import com.example.cookingapp.CallApi.message;
import com.example.cookingapp.CallApi.nguoidungdbfs;
import com.example.cookingapp.CallApi.nguoidungsavefs;
import com.example.cookingapp.Interface.IFood;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.model.FoodInFor;
import com.example.cookingapp.model.Register;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TuongTacFragment extends Fragment {
    RecyclerView recyclerSave;
    GetAllDAO getAllDAO;
    LuuMonAdapter foodinfoAdapter;
    List<nguoidungsavefs> nguoidungsavefsList;
    ArrayList<FoodInFor> foodInForList;
    String tenuser;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tuongtac_fragment, container, false);


        recyclerSave = view.findViewById(R.id.recyclerSave);
        SharedPreferences pref = getActivity().getSharedPreferences("USERNAME", MODE_PRIVATE);
        tenuser = pref.getString("username", "");
        loaddatafoodsave();

        foodinfoAdapter.setiFood(new IFood() {
            @Override
            public void onClickFood(FoodInFor foodInFor) {
                Intent intent = new Intent(getContext(), CTNLActivity.class);
                intent.putExtra("key1",foodInFor.getMamon());
                startActivity(intent);

            }
        });


        return view;
    }
     void loaddatafoodsave() {
        getAllDAO= new GetAllDAO(getContext());
        nguoidungsavefsList = new ArrayList<>();
        foodInForList = new ArrayList<>();
        nguoidungsavefsList = getAllDAO.getMaMonTheoTenNguoiDungSave(tenuser);

        for (nguoidungsavefs s : nguoidungsavefsList) {
            foodInForList.add(getAllDAO.getAllfoodtheomamon(s.getMamon()).get(0));
        }

        foodinfoAdapter = new LuuMonAdapter(getContext(), foodInForList);
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerSave.setLayoutManager(linearLayoutManager);
        recyclerSave.setAdapter(foodinfoAdapter);
    }





}
