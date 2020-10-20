package com.example.dattingfirebase.Activity.ProfileActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.dattingfirebase.R;

public class HeightActivity extends AppCompatActivity {
    private ImageView imgClose;
    private TextView tvSeekbar;
    private SeekBar seekBar;
    private ImageView imgTichVe;
    private Button btSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);

        initView();
        seekBar.setMax(300);
        seekBar.setProgress(150);
        tvSeekbar.setText(seekBar.getProgress() + " cm");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;//get value when progress change
                tvSeekbar.setText(progressChangedValue + " cm");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //handle when stop tracking touch
            }
        });
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                final String w = (String)tvSeekbar.getText();
                intent.putExtra("height",w);
                setResult(100,intent);
                //==================================================
                finish();
            }
        });
    }

    private void initView() {
        imgClose = findViewById(R.id.img_close);
        tvSeekbar = findViewById(R.id.tv_seekbar);
        seekBar = findViewById(R.id.seekBar);
        imgTichVe = findViewById(R.id.img_tichVe);
        btSkip = findViewById(R.id.bt_skip);
    }
}