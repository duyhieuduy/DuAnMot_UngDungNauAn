package com.example.cookingapp.Fragment;


import static com.example.cookingapp.CallApi.ApiService.BASE_Service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookingapp.Adapter.FoodinfoAdapter;
import com.example.cookingapp.Adapter.LMAdapter;
import com.example.cookingapp.CTNLActivity;
import com.example.cookingapp.CallApi.ApiService;
import com.example.cookingapp.CallApi.anhmonanfs;
import com.example.cookingapp.CallApi.binhluanfs;
import com.example.cookingapp.CallApi.congthucnguyenlieufs;
import com.example.cookingapp.CallApi.nguoidungdbfs;
import com.example.cookingapp.CallApi.nguoidungsavefs;
import com.example.cookingapp.Clicknl_func.NewNguyenlieuAdapter;
import com.example.cookingapp.Adapter.NguyenLieuAdapter;
import com.example.cookingapp.CallApi.Food;
import com.example.cookingapp.Interface.ApiInterface;
import com.example.cookingapp.Interface.IFood;
import com.example.cookingapp.Interface.ILM;
import com.example.cookingapp.Interface.INguyenLieu;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.GetAllDAO;
import com.example.cookingapp.dao.InsertDao;
import com.example.cookingapp.Clicknl_func.NewNguyenLieu;
import com.example.cookingapp.model.FoodInFor;
import com.example.cookingapp.model.LOAIMONmodel;
import com.example.cookingapp.model.NguyenLieu;
import com.example.cookingapp.Clicknl_func.dao;
import com.example.cookingapp.model.UserSave;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home_Fragment extends Fragment {
    RecyclerView recyclerviewHCK;
    RecyclerView recyclerviewnewHCK;
    ArrayList<NguyenLieu> listnl;
    ArrayList<NewNguyenLieu> listnewnl;
    dao newnldaoz;
    NguyenLieuAdapter adapter;
    InsertDao insertDao;
    GetAllDAO getAllDAO;
    RecyclerView recycLoaiMon;
    RecyclerView RecyclviewWating;
    ArrayList<LOAIMONmodel> listloaimon;
    ArrayList<FoodInFor> listfood;
    LMAdapter lmAdapter;
    FoodinfoAdapter foodForGetCmt;

    TextView tvtatca;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        recyclerviewHCK = view.findViewById(R.id.recyclviewKCH);
        recyclerviewnewHCK = view.findViewById(R.id.recyclviewnewKCH);
        recycLoaiMon = view.findViewById(R.id.recycLoaiMon);
        RecyclviewWating = view.findViewById(R.id.RecyclviewWating);

        insertDao = new InsertDao(getContext());
        getAllDAO = new GetAllDAO(getContext());
        listfood = new ArrayList<>();
        listnl = new ArrayList<>();
        listnewnl = new ArrayList<>();
        listloaimon = new ArrayList<>();

       // callApiGetUser();
        loadallmon();
        loaddataLoaiMon();
        loadDataNewnl();
        loadDataNl();

        TextView textView = view.findViewById(R.id.textview);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listfood.clear();
                loadallmon();
            }
        });






        adapter.setiNguyenLieu(new INguyenLieu() {
            @Override
            public void onClick(NguyenLieu nguyenLieu) {
                newnldaoz = new dao(getContext());
                newnldaoz.insert(nguyenLieu.getTennguyenlieu());
                loadDataNewnl();

                listfood.clear();
                getAllDAO = new GetAllDAO(getActivity());
                listfood =  getAllDAO.getAllfoodtheotennguyenlieu(nguyenLieu.getTennguyenlieu());
                foodForGetCmt = new FoodinfoAdapter(getContext(), listfood);
                GridLayoutManager gridView = new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
                RecyclviewWating.setLayoutManager(gridView);
                RecyclviewWating.setAdapter(foodForGetCmt);


            }
        });

        lmAdapter.setIlm(new ILM() {
            @Override
            public void OnclickLM(LOAIMONmodel loaimoNmodel) {

                listfood.clear();
                getAllDAO = new GetAllDAO(getActivity());
                listfood =  getAllDAO.getAllfoodtheomaloai(loaimoNmodel.getMaloai());
                foodForGetCmt = new FoodinfoAdapter(getContext(), listfood);
                GridLayoutManager gridView = new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
                RecyclviewWating.setLayoutManager(gridView);
                RecyclviewWating.setAdapter(foodForGetCmt);




            }
        });

        foodForGetCmt.setiFood(new IFood() {
            @Override
            public void onClickFood(FoodInFor foodInFor) {
                Intent intent = new Intent(getContext(), CTNLActivity.class);
                intent.putExtra("key1",foodInFor.getMamon());
                startActivity(intent);
            }
        });


        Button btnReload = view.findViewById(R.id.btnReload);
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertDao insertDao = new InsertDao(getContext());

                insertDao.deleteAll();
                listfood.clear();
                listloaimon.clear();
                listnewnl.clear();
                listnl.clear();

                callApiGetUser();

                startActivity(new Intent(getContext(),WaitActivity.class));
                loadallmon();
            }
        });

        return view;


    }


    private void loadDataNl() {
        getAllDAO = new GetAllDAO(getActivity());
        listnl = getAllDAO.getAllnl();
        adapter = new NguyenLieuAdapter(getContext(), listnl);
        GridLayoutManager gridView = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        recyclerviewHCK.setLayoutManager(gridView);
        recyclerviewHCK.setAdapter(adapter);
    }


    private void loadDataNewnl() {
        listnewnl.clear();
        newnldaoz = new dao(getContext());
        listnewnl = newnldaoz.getall();
        LinearLayoutManager linearLayoutManagera = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerviewnewHCK.setLayoutManager(linearLayoutManagera);
        NewNguyenlieuAdapter adaptera = new NewNguyenlieuAdapter(getContext(), listnewnl);
        recyclerviewnewHCK.setAdapter(adaptera);
    }

    void loaddataLoaiMon() {
        listloaimon = new ArrayList<>();
        getAllDAO = new GetAllDAO(getContext());
        listloaimon = getAllDAO.getAlllm();
        LinearLayoutManager linearLayoutManagera = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycLoaiMon.setLayoutManager(linearLayoutManagera);
        lmAdapter = new LMAdapter(getContext(),listloaimon);
        recycLoaiMon.setAdapter(lmAdapter);
    }

    public void loadallmon(){
        getAllDAO = new GetAllDAO(getContext());
        listfood = new ArrayList<>();
        listfood = getAllDAO.getAll();
        foodForGetCmt = new FoodinfoAdapter(getContext(), listfood);
        GridLayoutManager gridView = new GridLayoutManager(getContext(),1,RecyclerView.HORIZONTAL,false);
        RecyclviewWating.setLayoutManager(gridView);
        RecyclviewWating.setAdapter(foodForGetCmt);
    }


    private void callApiGetUser() {
        ApiService requestInterface = new Retrofit.Builder()
                .baseUrl(BASE_Service)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiService.class);

        new CompositeDisposable().add(requestInterface.getListFood()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(ArrayList<Food> food) {
        InsertDao insertDao = new InsertDao(getContext());
        for (Food fooda : food) {
            insertDao.insertMON(
                    fooda.getMamon(),
                    fooda.getMaloai(),
                    fooda.getTenmon(),
                    fooda.getCongthuclam(),
                    fooda.getTgnau(),
                    fooda.getDokho(),
                    fooda.getAnhmonlvo(),
                    fooda.getCachlam());
            insertDao.insertLOAIMON(fooda.getMaloai(),fooda.getTenloai());

            for (anhmonanfs ama: fooda.getAnhmonanfs()) {
                insertDao.insertANHMONAN(ama.getIdAma(), ama.getMamon(), ama.getAnhmon());
            }

            for (binhluanfs binhluanfs: fooda.getBinhluanfs()) {
                insertDao.insertBINHLUAN(binhluanfs.getIdBl(), binhluanfs.getMamon(), binhluanfs.getTendangnhap(),binhluanfs.getNoidungbl());
            }

            for (congthucnguyenlieufs congthucnguyenlieufsa: fooda.getCongthucnguyenlieufs()) {
                insertDao.insertCONGTHUCNGUYENLIEU(congthucnguyenlieufsa.getIdctnl(), congthucnguyenlieufsa.getMamon(), congthucnguyenlieufsa.getTennguyenlieu(),congthucnguyenlieufsa.getKhoiluong());
            }


            for (nguoidungdbfs nguoidungdbfs: fooda.getNguoidungdbfs()) {
                insertDao.insertNGUOIDUNGDB(nguoidungdbfs.getIdndb(), nguoidungdbfs.getMamon(), nguoidungdbfs.getTennguoidung());
            }

            for (nguoidungsavefs  nguoidungsavefs: fooda.getNguoidungsavefs()) {
                insertDao.insertNGUOIDUNGSAVE(nguoidungsavefs.getIdnds(), nguoidungsavefs.getMamon(), nguoidungsavefs.getTennguoidung());
            }


        }


    }

    private void handleError(Throwable error) {
        Log.d("CALL LOI",")()())()()(" + error);
        Toast.makeText(getActivity(), "Call Fail  " + error, Toast.LENGTH_LONG).show();
    }

    private void senPostsUserSave(){
        UserSave userSave = new UserSave("1", 1);
        ApiInterface.apiInterface.senPostUserSave(userSave).enqueue(new Callback<UserSave>() {
            @Override
            public void onResponse(Call<UserSave> call, Response<UserSave> response) {
                Toast.makeText(getContext(), "call api success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserSave> call, Throwable t) {
                Toast.makeText(getContext(), "call api success", Toast.LENGTH_SHORT).show();

            }
        });
    }





}