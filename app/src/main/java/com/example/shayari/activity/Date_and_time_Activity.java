package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.shayari.R;

import java.util.Date;
import java.util.Locale;

public class Date_and_time_Activity extends AppCompatActivity {

    Button Date,time;
    ImageView arrow_forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        Date = findViewById(R.id.Date);
        time = findViewById(R.id.Time);
        arrow_forward = findViewById(R.id.arrow_forward);

        arrow_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Date_and_time_Activity.this,image_slider_Activity.class));
                finish();
            }
        });


        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog Date = new DatePickerDialog(Date_and_time_Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        Toast.makeText(Date_and_time_Activity.this, i2+" / "+(i1+1)+" / "+i, Toast.LENGTH_SHORT).show();
                    }
                },2022,0,1);
                Date.show();

            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog Time = new TimePickerDialog(Date_and_time_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(Date_and_time_Activity.this, i1+" : "+i, Toast.LENGTH_SHORT).show();
                    }
                },5,10,false);
                Time.show();
            }
        });

    }
}