package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shayari.R;

public class FragmentActivity extends AppCompatActivity {

    ImageView arrow_forward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        arrow_forward = findViewById(R.id.arrow_forward);

        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FragmentActivity.this,Dynamic_FragmentActivity.class));
            }
        });
    }
}