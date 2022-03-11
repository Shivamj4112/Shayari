package com.example.shayari.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shayari.R;
import com.google.android.material.navigation.NavigationView;

public class Navigation_drawerActivity extends AppCompatActivity {

    ImageView menu,arrow_forward;
    DrawerLayout drawer;
    NavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        menu = findViewById(R.id.menu);
        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        arrow_forward = findViewById(R.id.arrow_forward);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawer.openDrawer(Gravity.LEFT);
            }
        });

        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Navigation_drawerActivity.this,DatabaseTask1Activity.class));
            }
        });

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.about:
                        Toast.makeText(Navigation_drawerActivity.this, "About us", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}