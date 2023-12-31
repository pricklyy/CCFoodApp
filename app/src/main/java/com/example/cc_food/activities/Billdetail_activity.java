package com.example.cc_food.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cc_food.Admin.AdminActivity;
import com.example.cc_food.R;
import com.example.cc_food.Utility.NetworkChangeListener;
import com.example.cc_food.adapters.Billdetails_adapter;
import com.example.cc_food.modules.OderHistoryModelNew;
import com.example.cc_food.modules.billdetail_paid_model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Billdetail_activity extends AppCompatActivity {
    NetworkChangeListener networkChangeListener = new NetworkChangeListener();


    private RecyclerView RCL;
    ArrayList<OderHistoryModelNew> moduleArrayList = new ArrayList<>();
    ArrayList<billdetail_paid_model> arrayList = new ArrayList<>();

    Billdetails_adapter adapter;
    Button btnsukien;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billdetail);
        RCL = findViewById(R.id.rclbill);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        RCL.setLayoutManager(manager);
        adapter = new Billdetails_adapter(moduleArrayList, this);
        getdata();
        RCL.setAdapter(adapter);
        RCL.setHasFixedSize(true);
        RCL.setNestedScrollingEnabled(false);
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, intentFilter);
        super.onStart();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(arrayList!=null){
                    arrayList.clear();
                }
                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    arrayList.add(billdetailmodel1 );
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
        startActivity(new Intent(Billdetail_activity.this , AdminActivity.class));
    }

    public void getdata() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("objec_bill");
        Query query = reference.orderByChild("dateTime");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(moduleArrayList!=null){
                    moduleArrayList.clear();
                }
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    OderHistoryModelNew item = snapshot1.getValue(OderHistoryModelNew.class);
                    moduleArrayList.add( item);

                }


                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //cách 2
//        reference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                billdetailmodel item = snapshot.getValue(billdetailmodel.class);
//                   if(moduleArrayList!=null){
//                       moduleArrayList.add(item);
//                       adapter.notifyDataSetChanged();
//                   }
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("object_bill_paid");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(arrayList!=null){
                    arrayList.clear();
                }
                for(DataSnapshot snapshot1 :snapshot.getChildren()){
                    billdetail_paid_model billdetailmodel1 = snapshot1.getValue(billdetail_paid_model.class);
                    arrayList.add(billdetailmodel1 );
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


}