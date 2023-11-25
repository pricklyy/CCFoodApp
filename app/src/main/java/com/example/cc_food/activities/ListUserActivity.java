package com.example.cc_food.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cc_food.Admin.AdminActivity;
import com.example.cc_food.DAO.UsersDAO;
import com.example.cc_food.R;
import com.example.cc_food.Utility.NetworkChangeListener;
import com.example.cc_food.adapters.ListUserAdapter;
import com.example.cc_food.modules.UsersModule;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {
    private RecyclerView rcvListUser;
    ListUserAdapter listUserAdapter;
    ArrayList<UsersModule> listUser;
    static UsersDAO usersDAO;

    NetworkChangeListener networkChangeListener = new NetworkChangeListener();



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);


        usersDAO = new UsersDAO(getApplicationContext());
        rcvListUser = findViewById(R.id.rcvListUser);

        listUser = (ArrayList<UsersModule>) usersDAO.getALL();
        listUserAdapter = new ListUserAdapter(getApplicationContext(), listUser);
        rcvListUser.setAdapter(listUserAdapter);

        rcvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        rcvListUser.setHasFixedSize(true);
        rcvListUser.setNestedScrollingEnabled(false);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(), AdminActivity.class));
        finishAffinity();
    }
    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkChangeListener, intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkChangeListener);
        super.onStop();
    }
}