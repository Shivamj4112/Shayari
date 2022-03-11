package com.example.shayari.activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.Database1_Model;
import com.example.shayari.R;

import java.util.List;

public class DatabaseTask1Activity extends AppCompatActivity {

    EditText id;
    EditText fullname;
    EditText contacts;
    EditText email;
    EditText course;
    EditText fees;
    Database database;
    Button insert, retrive, update, delete;
    RecyclerView recycle;


    private static final String TAG = "DatabaseTask1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_task1);

        insert = findViewById(R.id.insert);
        retrive = findViewById(R.id.retrive);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        recycle = findViewById(R.id.recycle);

        id = findViewById(R.id.id);
        fullname = findViewById(R.id.fullname);
        contacts = findViewById(R.id.contacts);
        email = findViewById(R.id.email);
        course = findViewById(R.id.course);
        fees = findViewById(R.id.fees);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        database = new Database(DatabaseTask1Activity.this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Name = fullname.getText().toString();
                String Contacts = contacts.getText().toString();
                String Email = email.getText().toString();
                String Course = course.getText().toString();
                String Fees = fees.getText().toString();


                if (Name.isEmpty() && Contacts.isEmpty() && Email.isEmpty() && Course.isEmpty() && Fees.isEmpty()) {

                    fullname.setError("Enter Fullname");
                    contacts.setError("Enter Contacts");
                    email.setError("Enter Email");
                    course.setError("Enter Course");
                    fees.setError("Enter Fees");
                } else {

                    database.InsertData(Name, Contacts, Email, Course, Fees);

                    fullname.setText("");
                    contacts.setText("");
                    email.setText("");
                    course.setText("");
                    fees.setText("");
                }

            }
        });


        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                List<Database1_Model> datalist = database.RetriveData();

                recycle.setLayoutManager(new LinearLayoutManager(DatabaseTask1Activity.this));
                recycle.setAdapter(new DatabaseRecycle(DatabaseTask1Activity.this, datalist));
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Database1_Model> datalist = database.RetriveData();

                int Id = Integer.parseInt(id.getText().toString());
                String Name = fullname.getText().toString();
                String Contacts = contacts.getText().toString();
                String Email = email.getText().toString();
                String Course = course.getText().toString();
                String Fees = fees.getText().toString();


                database.UpdateData(Id, Name, Contacts, Email, Course, Fees);

                recycle.setLayoutManager(new LinearLayoutManager(DatabaseTask1Activity.this));
                recycle.setAdapter(new DatabaseRecycle(DatabaseTask1Activity.this, datalist));

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Database1_Model> datalist = database.RetriveData();

                int Id = Integer.parseInt(id.getText().toString());

                database.DeleteData(Id);

                recycle.setLayoutManager(new LinearLayoutManager(DatabaseTask1Activity.this));
                recycle.setAdapter(new DatabaseRecycle(DatabaseTask1Activity.this, datalist));

            }
        });
    }


}