package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shayari.R;

public class SharedpreferenceActivity extends AppCompatActivity {

    Button sub;
    EditText email, pass;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference);

        preferences = getSharedPreferences("Login", 0);
        editor = preferences.edit();

        sub = findViewById(R.id.sub);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);


        if (!preferences.getString("email", "").matches("") || !preferences.getString("password", "").matches("")) {

            startActivity(new Intent(SharedpreferenceActivity.this, MainActivity.class));
            finish();
        }
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor.putString("email", email.getText().toString());
                editor.putString("password", pass.getText().toString());
                editor.commit();

                String email = preferences.getString("email", "");
                String pass = preferences.getString("password", "");

                if (email.isEmpty() || pass.isEmpty()){

                    Toast.makeText(SharedpreferenceActivity.this, "Email and Password is Empty", Toast.LENGTH_SHORT).show();
                }
                else{

                    startActivity(new Intent(SharedpreferenceActivity.this,MainActivity.class));
                    finish();
                }


            }
        });

    }
}