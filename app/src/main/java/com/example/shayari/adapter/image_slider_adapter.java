package com.example.shayari.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.shayari.R;
import com.example.shayari.activity.image_slider_Activity;

public class image_slider_adapter extends PagerAdapter {

    Activity activity;
    int[] image;
    public image_slider_adapter(image_slider_Activity image_slider_activity, int[] image) {
        activity = image_slider_activity;
        this.image = image;
    }
    @Override
    public int getCount() {
        return image.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(activity).inflate(R.layout.image_slider, container, false);
        ImageView imageView = view.findViewById(R.id.image);

        Glide.with(activity).load(image[position]).into(imageView);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
