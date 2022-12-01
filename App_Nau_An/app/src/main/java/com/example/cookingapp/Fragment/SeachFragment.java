package com.example.cookingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cookingapp.Adapter.SearchAdapter;
import com.example.cookingapp.R;
import com.example.cookingapp.dao.CongThucNguyenLieuDAO;
import com.example.cookingapp.model.FoodInFor;

import java.util.ArrayList;

public class SeachFragment extends Fragment {
    private RecyclerView recyclerFood;
    private SearchAdapter searchAdapter;
    private SearchView searchView;
    private ArrayList<FoodInFor> getListFoodOld;
    CongThucNguyenLieuDAO congThucNguyenLieuDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);
        searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.getFilter().filter(newText);
                return false;
            }
        });

        recyclerFood = view.findViewById(R.id.recyclerFood);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerFood.setLayoutManager(linearLayoutManager);
        getListFoodOld = new ArrayList<>();
//        getListFoodOld = congThucNguyenLieuDAO.getAll();
//        congThucNguyenLieuDAO = new CongThucNguyenLieuDAO(getContext());
//        searchAdapter = new SearchAdapter(getActivity(),getListFoodOld);
        recyclerFood.setAdapter(searchAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerFood.addItemDecoration(itemDecoration);
        return view;
    }

}
