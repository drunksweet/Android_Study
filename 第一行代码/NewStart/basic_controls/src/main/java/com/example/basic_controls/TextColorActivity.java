package com.example.basic_controls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TextColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color);
        TextView textView_code_system=findViewById(R.id.textView_code_system);
        textView_code_system.setTextColor(0xFFFFFFFF);
    }
}