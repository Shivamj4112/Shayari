package com.example.shayari.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.Database1_Model;
import com.example.shayari.R;

import java.util.List;

public class DatabaseTask3Activity extends AppCompatActivity {

    EditText id;
    EditText fullname;
    EditText contacts;
    EditText email;
    EditText course;
    EditText fees;
    Button insert;

    public static Database database;
    public static RecyclerView recycle;
    public static LinearLayoutManager manager;
    public static DataRecycleTask3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_task3);

        insert = findViewById(R.id.insert);
        recycle = findViewById(R.id.recycle);

        id = findViewById(R.id.id);
        fullname = findViewById(R.id.fullname);
        contacts = findViewById(R.id.contacts);
        email = findViewById(R.id.email);
        course = findViewById(R.id.course);
        fees = findViewById(R.id.fees);

        database = new Database(DatabaseTask3Activity.this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = fullname.getText().toString();
                String Contacts = contacts.getText().toString();
                String Email = email.getText().toString();
                String Course = course.getText().toString();
                String Fees = fees.getText().toString();

                if (Name.matches("") && Contacts.matches("") && Email.matches("") && Course.matches("") && Fees.matches("")){

                    fullname.setError("Enter name");
                    contacts.setError("Enter name");
                    email.setError("Enter name");
                    course.setError("Enter name");
                    fees.setError("Enter name");

                    refresh(DatabaseTask3Activity.this);

                }else{
                    database.InsertData(Name, Contacts, Email, Course, Fees);

                    refresh(DatabaseTask3Activity.this);

                }

            }
        });
    }

    public static void refresh(Activity context) {


        List<Database1_Model> datalist = database.RetriveData();

        manager = new LinearLayoutManager(context);
        adapter = new DataRecycleTask3(context, datalist);

        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);


    }

}