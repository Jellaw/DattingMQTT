package com.example.dattingfirebase.Activity.ProfileActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.dattingfirebase.R;

public class EditAccountActivity extends AppCompatActivity {
    TextView hoten;
    TextView dob;
    TextView gioitinh;
    TextView save_btn;
    EditText accName;
    EditText dobAcc;
    RadioButton male;
    RadioButton female;
    ImageView back_btn;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        init();
        i = getIntent();
        accName.setText(i.getStringExtra("name"));

        accName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hoten.setTextColor(Color.parseColor("#E3608C"));
                dob.setTextColor(Color.parseColor("#757171"));
                return false;
            }
        });
        dobAcc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                dob.setTextColor(Color.parseColor("#E3608C"));
                hoten.setTextColor(Color.parseColor("#757171"));
                return false;
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //truyen name_edited sang fragment Profile
                Intent intent=new Intent();
                intent.putExtra("ten",accName.getText().toString());
                setResult(999,intent);
                //==================================================
                finish();
            }
        });
    }
    private void init(){
        hoten = findViewById(R.id.hoten);
        dob= findViewById(R.id.dob);
        gioitinh = findViewById(R.id.sex);

        accName = findViewById(R.id.nameText);
        dobAcc = findViewById(R.id.dobText);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        back_btn = findViewById(R.id.back_btn_acc);
        save_btn = findViewById(R.id.save_btn);
    }
}
