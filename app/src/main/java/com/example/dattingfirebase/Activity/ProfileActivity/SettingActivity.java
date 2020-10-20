package com.example.dattingfirebase.Activity.ProfileActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dattingfirebase.R;

public class SettingActivity extends AppCompatActivity {

    ImageView back_setting_btn;
    TextView policy;
    TextView acc_security;
    TextView notificion;
    TextView about;
    TextView support;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //Init===================================
        back_setting_btn = findViewById(R.id.back_btn_setting);
        policy = findViewById(R.id.policy);
        acc_security = findViewById(R.id.acc_security);
        notificion = findViewById(R.id.notification);
        about =findViewById(R.id.about);
        support = findViewById(R.id.support);
        //========================================
        back_setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        acc_security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acc_security.setBackgroundColor(Color.parseColor("#80EDEAEA"));
                new CountDownTimer(500, 1000) {
                    @Override
                    public void onTick(long l) {
                    }
                    public void onFinish() {
                        acc_security.setBackgroundColor(Color.parseColor("#FFFDFBFB"));
                    }
                }.start();

            }
        });
    }

}
