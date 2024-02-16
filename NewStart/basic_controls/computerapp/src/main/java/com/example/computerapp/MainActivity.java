package com.example.computerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv_result = findViewById(R.id.tv_result);

        findViewById(R.id.btn_CE).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

    }
}