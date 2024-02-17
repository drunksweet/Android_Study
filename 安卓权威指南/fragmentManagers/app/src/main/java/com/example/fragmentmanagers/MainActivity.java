package com.example.fragmentmanagers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =findViewById(R.id.change_btn);
        button.setOnClickListener(this);

        Button button2 =findViewById(R.id.replace_btn);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.replace_btn){
            replaceFragment(new BlankFragment1());
        } else if (id ==R.id.change_btn) {
            replaceFragment(new ListFragment());
        }

        }


        private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction transation = fragmentManager.beginTransaction();
        transation.addToBackStack(null);
        transation.replace(R.id.framelayout,fragment).commit();

    }
}