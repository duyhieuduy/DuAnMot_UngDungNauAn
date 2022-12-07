package com.example.cookingapp;

import static com.example.cookingapp.CallApi.ApiService.BASE_Service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cookingapp.Adapter.ViewPagerAdapter;
import com.example.cookingapp.CallApi.ApiService;
import com.example.cookingapp.CallApi.Food;
import com.example.cookingapp.CallApi.anhmonanfs;
import com.example.cookingapp.CallApi.binhluanfs;
import com.example.cookingapp.CallApi.congthucnguyenlieufs;
import com.example.cookingapp.CallApi.nguoidungdbfs;
import com.example.cookingapp.CallApi.nguoidungsavefs;
import com.example.cookingapp.dao.InsertDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Menu_Activity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ViewPager mViewPager;
    BottomNavigationView bottom;
    InsertDao insertDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);



        bottom = findViewById(R.id.bottom);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        mViewPager = findViewById(R.id.maincontent);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        setUpViewPager();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.trangchu:
                        mViewPager.setCurrentItem(0);
                        bottom.setSelectedItemId(R.id.trangchu);
                        break;
                    case R.id.logout:
                        startActivity(new Intent(Menu_Activity.this,Login_Activity.class));
                        break;
                    case R.id.back:
                        new AlertDialog.Builder(Menu_Activity.this)
                                .setMessage("Ban co chac chan muon thoat")
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        moveTaskToBack(true);
                                        android.os.Process.killProcess(android.os.Process.myPid());
                                        System.exit(0);
                                        finish();
                                    }
                                })
                                .setNegativeButton("No",null)
                                .show();

                        break;
                    default:
                        mViewPager.setCurrentItem(0);
                        break;
                }

                return false;
            }
        });

        bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.trangchu:
                        mViewPager.setCurrentItem(0);
                        toolbar.setTitle("Home");
                        break;
                    case R.id.trangmot:
                        mViewPager.setCurrentItem(1);
                        toolbar.setTitle("trangmot");
                        break;
                    case R.id.tranghai:
                        mViewPager.setCurrentItem(2);
                        toolbar.setTitle("tranghai");
                        break;
                    case R.id.trangba:
                        mViewPager.setCurrentItem(3);
                        toolbar.setTitle("trangba");
                        break;
                    case R.id.trangbon:
                        mViewPager.setCurrentItem(4);
                        toolbar.setTitle("trangbon");
                        break;
                    default:
                        mViewPager.setCurrentItem(0);
                        break;
                }
                return true;
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottom.getMenu().findItem(R.id.trangchu1).setChecked(true);
                        break;
                    case 1:
                        bottom.getMenu().findItem(R.id.trangmot).setChecked(true);
                        break;
                    case 2:
                        bottom.getMenu().findItem(R.id.tranghai).setChecked(true);
                        break;
                    case 3:
                        bottom.getMenu().findItem(R.id.trangba).setChecked(true);
                        break;
                    case 4:
                        bottom.getMenu().findItem(R.id.trangbon).setChecked(true);
                        break;
                    default:

                        bottom.getMenu().findItem(R.id.trangchu1).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        Log.d("AAA",food.get(0).getTenmon());
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

            for (com.example.cookingapp.CallApi.binhluanfs binhluanfs: fooda.getBinhluanfs()) {
                insertDao.insertBINHLUAN(binhluanfs.getIdBl(), binhluanfs.getMamon(), binhluanfs.getTendangnhap(),binhluanfs.getNoidungbl());
            }

            for (congthucnguyenlieufs congthucnguyenlieufsa: fooda.getCongthucnguyenlieufs()) {
                insertDao.insertCONGTHUCNGUYENLIEU(congthucnguyenlieufsa.getIdctnl(), congthucnguyenlieufsa.getMamon(), congthucnguyenlieufsa.getTennguyenlieu(),congthucnguyenlieufsa.getKhoiluong());
            }


            for (com.example.cookingapp.CallApi.nguoidungdbfs nguoidungdbfs: fooda.getNguoidungdbfs()) {
                insertDao.insertNGUOIDUNGDB(nguoidungdbfs.getIdndb(), nguoidungdbfs.getMamon(), nguoidungdbfs.getTennguoidung());
            }

            for (com.example.cookingapp.CallApi.nguoidungsavefs nguoidungsavefs: fooda.getNguoidungsavefs()) {
                insertDao.insertNGUOIDUNGSAVE(nguoidungsavefs.getIdnds(), nguoidungsavefs.getMamon(), nguoidungsavefs.getTennguoidung());
            }


        }


    }

    private void handleError(Throwable error) {
        Log.d("CALL LOI",")()())()()(" + error);
        Toast.makeText(Menu_Activity.this, "Call Fail  " + error, Toast.LENGTH_LONG).show();
    }

}
