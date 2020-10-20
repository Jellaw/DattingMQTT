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

public class WeightActivity extends AppCompatActivity {
    private ImageView imgClose;
    private TextView tvSeekbar;
    private SeekBar seekBar;
    private ImageView imgTichVe;
    private Button btSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        initView();
        seekBar.setMax(100);
        seekBar.setProgress(50);
        tvSeekbar.setText(seekBar.getProgress() + " kg");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;//get value when progress change
                tvSeekbar.setText(progressChangedValue + " kg");

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
                intent.putExtra("weight",w);
                setResult(200,intent);
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