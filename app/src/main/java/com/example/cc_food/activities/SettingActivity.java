package com.example.cc_food.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cc_food.R;
import com.example.cc_food.Utility.NetworkChangeListener;


public class SettingActivity extends AppCompatActivity {
    TextView btnChangePass, setting_Edit_Profile;

    NetworkChangeListener networkChangeListener = new NetworkChangeListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        btnChangePass = findViewById(R.id.setting_Edit_Pass);
        setting_Edit_Profile = findViewById(R.id.setting_Edit_Profile);
        setting_Edit_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, UserUpdateInfoActivity.class));

            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this, ChangePass_Setting_Activity.class));
            }
        });
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
