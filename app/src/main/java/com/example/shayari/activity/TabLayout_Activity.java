package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shayari.R;
import com.example.shayari.adapter.viewpager_fragment_adapter;
import com.google.android.material.tabs.TabLayout;

public class TabLayout_Activity extends AppCompatActivity {

    ImageView arrow_forward;
    TabLayout tabs;
    ViewPager view_pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        arrow_forward = findViewById(R.id.arrow_forward);
        tabs = findViewById(R.id.tabs);
        view_pager = findViewById(R.id.view_pager);

        tabs.addTab(tabs.newTab().setText("First"));
        tabs.addTab(tabs.newTab().setText("Second"));

        viewpager_fragment_adapter adapter = new viewpager_fragment_adapter(getSupportFragmentManager());
        view_pager.setAdapter(adapter);

        tabs.setupWithViewPager(view_pager);

        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TabLayout_Activity.this,Navigation_drawerActivity.class));
                finish();
            }
        });
    }
}