package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.shayari.R;
import com.example.shayari.adapter.image_slider_adapter;

public class image_slider_Activity extends AppCompatActivity {

    ImageView arrow_forward;
    ViewPager view_pager;
    int[] image = new int[]{R.drawable.harsh_1,R.drawable.harsh_2,R.drawable.harsh_3,R.drawable.harsh_4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        arrow_forward = findViewById(R.id.arrow_forward);
        view_pager = findViewById(R.id.view_pager);

        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(image_slider_Activity.this,viewpager_fragment_Activity.class));
                finish();
            }
        });

        image_slider_adapter imageadapter = new image_slider_adapter(image_slider_Activity.this,image);
        view_pager.setAdapter(imageadapter);


    }
}