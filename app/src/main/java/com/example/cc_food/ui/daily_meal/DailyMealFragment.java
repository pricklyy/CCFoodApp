package com.example.cc_food.ui.daily_meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cc_food.R;
import com.example.cc_food.adapters.DailyMealAdapter;
import com.example.cc_food.modules.DailyMealModule;

import java.util.ArrayList;
import java.util.List;

public class DailyMealFragment extends Fragment {
    RecyclerView recyclerView;
    List<DailyMealModule> dailyMealModules;
    DailyMealAdapter dailyMealAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_daily_meal, container, false);
        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModules = new ArrayList<>();
        dailyMealModules.add(new DailyMealModule(R.drawable.breakfast, "Breakfast", "30% OFF", "Bữa sáng ngon lành", "breakfast"));
        dailyMealModules.add(new DailyMealModule(R.drawable.lunch, "Lunch", "20% OFF", "Bữa trưa thú vị", "lunch"));
        dailyMealModules.add(new DailyMealModule(R.drawable.dinner, "Dinner", "50% OFF", "Bữa tối đậm đà", "dinner"));
        dailyMealModules.add(new DailyMealModule(R.drawable.sweets, "Sweets", "25% OFF", "Thêm kẹo thêm ngọt", "sweets"));
        dailyMealModules.add(new DailyMealModule(R.drawable.coffee, "Coffee", "10% OFF", "Làm cốc cà phê", "coffee"));

        dailyMealAdapter = new DailyMealAdapter(getContext(), dailyMealModules);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();
        return root;
    }

}