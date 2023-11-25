package com.example.cc_food.activities;

import android.annotation.SuppressLint;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;


import com.example.cc_food.R;
import com.example.cc_food.Utility.NetworkChangeListener;
import com.example.cc_food.adapters.Account_ViewPageAdapter;
import com.example.cc_food.ui.oder.CanceledFragment;
import com.example.cc_food.ui.oder.SuccessfulFragment;
import com.example.cc_food.ui.oder.WaitingFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class StatusOderActivity extends AppCompatActivity {
    TabLayout tabLayout;
    Account_ViewPageAdapter viewPageAdapter;
    ViewPager2 viewPager2;

    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oder_status);

        tabLayout = findViewById(R.id.oder_TabLayout);
        viewPager2 = findViewById(R.id.oder_ViewPager);
        viewPageAdapter = new Account_ViewPageAdapter(this);

        viewPageAdapter.addFragment(new WaitingFragment());
        viewPageAdapter.addFragment(new CanceledFragment());
        viewPageAdapter.addFragment(new SuccessfulFragment());

        viewPager2.setAdapter(viewPageAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Đơn hàng đang chờ");
                        break;

                    case 1:
                        tab.setText("Đơn hàng đã huỷ");
                        break;
                    case 2:
                        tab.setText("Đơn hàng thành công");
                        break;
                }
            }
        }).attach();
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
