package com.example.cc_food.ui.favourite.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cc_food.R;
import com.example.cc_food.adapters.FeaturedAdapter;
import com.example.cc_food.adapters.FeaturedVerAdapter;
import com.example.cc_food.modules.FeaturedModule;
import com.example.cc_food.modules.RecommendedModule;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {

    ///////Hor
    List<FeaturedModule> featuredModules;
    RecyclerView recyclerView;
    FeaturedAdapter featuredAdapter;
    //////Ver
    List<RecommendedModule> foods;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        recyclerView = view.findViewById(R.id.featured_hor_rec2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        featuredModules = new ArrayList<>();
        featuredModules.add(new FeaturedModule(R.drawable.popular1, "Popular 1", "Description 1"));
        featuredModules.add(new FeaturedModule(R.drawable.popular2, "Popular 2", "Description 2"));
        featuredModules.add(new FeaturedModule(R.drawable.popular3, "Popular 3", "Description 3"));
        featuredModules.add(new FeaturedModule(R.drawable.popular3, "Popular 4", "Description 4"));
        featuredModules.add(new FeaturedModule(R.drawable.popular3, "Popular 5", "Description 5"));

        featuredAdapter = new FeaturedAdapter(featuredModules);
        recyclerView.setAdapter(featuredAdapter);
///////////////ver

        recyclerView2 = view.findViewById(R.id.featured_ver_rec2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        foods = new ArrayList<>();
        foods.add(new RecommendedModule(R.drawable.popular4, "Foie Gras", 3.5, R.drawable.plus_circle));
        foods.add(new RecommendedModule(R.drawable.popular5, "Sausage", 1.2, R.drawable.plus_circle));
        foods.add(new RecommendedModule(R.drawable.popular6, "Crepe Cake", 2.6, R.drawable.plus_circle));
        foods.add(new RecommendedModule(R.drawable.popular6, "Crepe Cake 2", 2.6, R.drawable.plus_circle));
        foods.add(new RecommendedModule(R.drawable.popular6, "Crepe Cake 3", 2.6, R.drawable.plus_circle));


        featuredVerAdapter = new FeaturedVerAdapter(getContext(), foods);
        recyclerView2.setAdapter(featuredVerAdapter);
        return view;
    }
}