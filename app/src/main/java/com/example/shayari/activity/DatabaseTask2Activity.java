package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shayari.Database1_Model;
import com.example.shayari.R;

import java.util.List;

public class DatabaseTask2Activity extends AppCompatActivity {

    EditText id , fullname , contacts , email , course , fees;
    Database database = new Database(DatabaseTask2Activity.this);
    Button insert, update, delete;
    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databse_task2);


        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        recycle = findViewById(R.id.recycle);

        id = findViewById(R.id.id);
        fullname = findViewById(R.id.fullname);
        contacts = findViewById(R.id.contacts);
        email = findViewById(R.id.email);
        course = findViewById(R.id.course);
        fees = findViewById(R.id.fees);


//        database = new Database(DatabaseTask2Activity.this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = fullname.getText().toString();
                String Contacts = contacts.getText().toString();
                String Email = email.getText().toString();
                String Course = course.getText().toString();
                String Fees = fees.getText().toString();

                if (Name.matches("")){

                    fullname.setError("Enter Fullname");
                }
                else if (Contacts.matches("")){

                    contacts.setError("Enter Contacts");
                }
                else if (Email.matches("")){

                    email.setError("Enter Contacts");
                }
                else if (Course.matches("")){

                    course.setError("Enter Course");
                }
                else if (Fees.matches("")){

                    fees.setError("Enter Fees");
                }
                else {

                    fullname.setText("");
                    contacts.setText("");
                    email.setText("");
                    course.setText("");
                    fees.setText("");

                    database.InsertData(Name, Contacts, Email, Course, Fees);
                    Toast.makeText(DatabaseTask2Activity.this, "Date Added", Toast.LENGTH_SHORT).show();

                    List<Database1_Model>datalist = database.RetriveData();

                    recycle.setLayoutManager(new LinearLayoutManager(DatabaseTask2Activity.this));
                    recycle.setAdapter(new DatabaseRecycle(DatabaseTask2Activity.this,datalist));
                }


            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int Id = Integer.parseInt(id.getText().toString());
                String Name = fullname.getText().toString();
                String Contacts = contacts.getText().toString();
                String Email = email.getText().toString();
                String Course = course.getText().toString();
                String Fees = fees.getText().toString();

                database.UpdateData(Id, Name, Contacts, Email, Course, Fees);

                List<Database1_Model>datalist = database.RetriveData();

                recycle.setLayoutManager(new LinearLayoutManager(DatabaseTask2Activity.this));
                recycle.setAdapter(new DatabaseRecycle(DatabaseTask2Activity.this,datalist));

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int Id = Integer.parseInt(id.getText().toString());
                database.DeleteData(Id);

                List<Database1_Model>datalist = database.RetriveData();

                recycle.setLayoutManager(new LinearLayoutManager(DatabaseTask2Activity.this));
                recycle.setAdapter(new DatabaseRecycle(DatabaseTask2Activity.this,datalist));

            }
        });
    }
}