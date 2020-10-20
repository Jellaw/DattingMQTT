package com.example.dattingfirebase.Activity.ProfileActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dattingfirebase.R;

public class JobAndStudy extends AppCompatActivity {
    TextView company;
    TextView job;
    TextView save_btn;
    EditText companyEditText;
    EditText jobEditText;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_and_study);
        init();
        //======================set action=======================================
        companyEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                company.setTextColor(Color.parseColor("#E3608C"));
                job.setTextColor(Color.parseColor("#757171"));
                return false;
            }
        });
        jobEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                job.setTextColor(Color.parseColor("#E3608C"));
                company.setTextColor(Color.parseColor("#757171"));
                return false;
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //==========================save action====================================
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JobAndStudy.this, MyInfomationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        company = findViewById(R.id.company);
        companyEditText = findViewById(R.id.companyText);
        job = findViewById(R.id.job);
        jobEditText = findViewById(R.id.jobText);
        save_btn = findViewById(R.id.save_btn);
        back_btn = findViewById(R.id.back_btn_job);
    }
}
