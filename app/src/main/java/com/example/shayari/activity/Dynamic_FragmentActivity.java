package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shayari.R;
import com.example.shayari.fragment.FirstFragment;
import com.example.shayari.fragment.SecondFragment;

public class Dynamic_FragmentActivity extends AppCompatActivity {

    Button button1;
    ImageView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        button1 = findViewById(R.id.button1);
        arrow_forward = findViewById(R.id.arrow_forward);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirstFragment fragment1 = new FirstFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment1,fragment1);
                transaction.commit();

            }
        });
        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Dynamic_FragmentActivity.this,Date_and_time_Activity.class));
                finish();
            }
        });
    }
}