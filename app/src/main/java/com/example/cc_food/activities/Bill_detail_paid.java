package com.example.cc_food.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cc_food.R;
import com.example.cc_food.adapters.Billdetail_paid_Adapter;
import com.example.cc_food.modules.billdetail_paid_model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Bill_detail_paid extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<billdetail_paid_model> list  = new ArrayList<>();
    Billdetail_paid_Adapter adapter;
    double doanhthu ;
    int i = 0 ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail_paid);
        recyclerView = findViewById(R.id.rclbillpaid);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new Billdetail_paid_Adapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.setNestedScrollingEnabled(false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        Query query = reference.orderByChild("tongtien");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(list!=null){
                    list.clear();
                }
                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    list.add( billdetailmodel1 );
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(list!=null){
                    list.clear();
                }
                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    list.add(billdetailmodel1 );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(list!=null){
                    list.clear();
                }
                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    list.add(billdetailmodel1 );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    list.add(billdetailmodel1 );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    list.add(billdetailmodel1 );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}