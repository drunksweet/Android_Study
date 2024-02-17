package com.example.first_line_code;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button startAct3_button = (Button) findViewById(R.id.StartAct3_btn);
        startAct3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:15057318089"));
                startActivity(intent);
            }
        });

        Button finished_button=(Button) findViewById(R.id.finished_btn);
        finished_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            snackbar提示
//                Snackbar snackbar=Snackbar.make(findViewById(R.id.btn1),"you click the Button_1",Snackbar.LENGTH_SHORT);
//                snackbar.setBackgroundTint(Color.BLUE);
//                snackbar.setTextColor(Color.CYAN);
//                snackbar.setAction("关闭", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        snackbar.dismiss();
//                    }
//                });
//                snackbar.show();

                Toast toast=Toast.makeText(MainActivity.this,"you click the Button_1",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();

                Intent intent =new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId==R.id.add_item){
            Toast.makeText(this,"click add",Toast.LENGTH_SHORT).show();
        } else if (itemId==R.id.remove_item) {
            Toast.makeText(this,"click remove",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
//    public void doPopupOptionsMenu(View view){
//        openOptionsMenu();
//    }
//
//    @Override
//    public void openOptionsMenu() {
//        final View toolbar = getWindow().getDecorView().findViewById(R.id.btn1);
//        if (toolbar instanceof Toolbar){
//            ((Toolbar) toolbar).showOverflowMenu();
//        }else{
//            super.openOptionsMenu();
//        }
//    }

}