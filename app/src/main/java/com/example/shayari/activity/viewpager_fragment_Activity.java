package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shayari.R;
import com.example.shayari.adapter.viewpager_fragment_adapter;

public class viewpager_fragment_Activity extends AppCompatActivity {

    ViewPager view_fragment;
    ImageView arrow_forward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_fragment);

        arrow_forward = findViewById(R.id.arrow_forward);
        view_fragment = findViewById(R.id.view_fragment);

        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(viewpager_fragment_Activity.this, TabLayout_Activity.class));
                finish();
            }
        });

        viewpager_fragment_adapter adapter =  new viewpager_fragment_adapter(getSupportFragmentManager());
        view_fragment.setAdapter(adapter);
    }
}