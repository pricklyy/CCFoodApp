package com.example.cc_food.adapters;


import com.example.cc_food.modules.AddRecommendModule;
import com.example.cc_food.modules.HomeVerModule;
import com.example.cc_food.modules.RecommendedModule;

import java.util.ArrayList;

public interface UpdateVerticalRec {
    public  void callBack(int pos , ArrayList<HomeVerModule> list);
    public  void callBackNew(int pos , ArrayList<RecommendedModule> list, ArrayList<AddRecommendModule> listNew);
}
