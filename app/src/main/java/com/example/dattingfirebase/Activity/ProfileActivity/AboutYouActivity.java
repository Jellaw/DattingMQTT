package com.example.dattingfirebase.Activity.ProfileActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dattingfirebase.R;

public class AboutYouActivity extends AppCompatActivity {
    TextView save_btn;
    ImageView back_btn;
    EditText introduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);
        init();
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
                intent.putExtra("gioithieu",introduce.getText().toString());
                setResult(111,intent);
                //==================================================
                finish();
            }
        });
    }
    private void init(){
        back_btn = findViewById(R.id.back_btn_about);
        save_btn=findViewById(R.id.save_btn);
        introduce=findViewById(R.id.introduce);
    }
}
