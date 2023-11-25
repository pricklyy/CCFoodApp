package com.example.cc_food.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.cc_food.adapters.recommend.ItemStatisticalRecommend;
import com.example.cc_food.database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class StatisticalDAO {
    private SQLiteDatabase db;
    private Context context;

    public StatisticalDAO(Context context) {
        this.context = context;
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }



    // get best seller
    @SuppressLint("Range")
    public List<ItemStatisticalRecommend> getTop(){
        //String sql = "SELECT idRecommend, COUNT(idUser) AS Solanmua FROM ItemCart GROUP BY idRecommend";
        String sql = "SELECT idRecommend, sum(quantities) AS Soluongmua FROM SystemCart GROUP BY idRecommend ORDER BY  Soluongmua DESC";
        List<ItemStatisticalRecommend> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            ItemStatisticalRecommend item = new ItemStatisticalRecommend();
            item.idRecommend = Integer.parseInt(cursor.getString(cursor.getColumnIndex("idRecommend")));
            item.quantities = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Soluongmua")));
            list.add(item);
        }
        if (list != null){
            return list;
        }
        return null;

    }

}
