package com.example.shayari.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.Database1_Model;
import com.example.shayari.R;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class DataRecycleTask3 extends RecyclerView.Adapter<DataRecycleTask3.Dataholder> {

    Activity activity;
    List<Database1_Model> datalist;
    Database database;


    public DataRecycleTask3(Activity activity, List<Database1_Model> datalist) {

        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.task3_layout, parent, false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, @SuppressLint("RecyclerView") int position) {

        holder.id.setText(datalist.get(position).id + "");
        holder.fullname.setText(datalist.get(position).fullname);
        holder.contacts.setText(datalist.get(position).contacts);
        holder.email.setText(datalist.get(position).email);
        holder.course.setText(datalist.get(position).course);
        holder.fees.setText(datalist.get(position).fees);

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.update_dialog);

                MaterialButton update = dialog.findViewById(R.id.update);
                MaterialButton cancel = dialog.findViewById(R.id.cancel_update);

                TextView id = dialog.findViewById(R.id.id);
                id.setText(datalist.get(position).id+"");

                EditText fullname = dialog.findViewById(R.id.fullname);
                EditText contacts = dialog.findViewById(R.id.contacts);
                EditText email = dialog.findViewById(R.id.email);
                EditText course = dialog.findViewById(R.id.course);
                EditText fees = dialog.findViewById(R.id.fees);

                fullname.setText(datalist.get(position).fullname);
                contacts.setText(datalist.get(position).contacts);
                email.setText(datalist.get(position).email);
                course.setText(datalist.get(position).course);
                fees.setText(datalist.get(position).fees);

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        database = new Database(activity);

                        List<Database1_Model> datalist = database.RetriveData();

                        String Name = fullname.getText().toString();
                        String Contacts = contacts.getText().toString();
                        String Email = email.getText().toString();
                        String Course = course.getText().toString();
                        String Fees = fees.getText().toString();

                        database.UpdateData(datalist.get(position).id,Name , Contacts, Email, Course, Fees);
                        dialog.dismiss();

                        DatabaseTask3Activity.refresh(activity);

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                        Toast.makeText(activity, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.delete_dialog);

                MaterialButton delete = dialog.findViewById(R.id.delete);
                MaterialButton cancel = dialog.findViewById(R.id.cancel);

                TextView id = dialog.findViewById(R.id.id);
                id.setText(datalist.get(position).id+"");

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        database = new Database(activity);

                        List<Database1_Model> datalist = database.RetriveData();

                        database.DeleteData(datalist.get(position).id);
                        dialog.dismiss();
                        DatabaseTask3Activity.refresh(activity);
                        Toast.makeText(activity, "Data deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                        Toast.makeText(activity, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class Dataholder extends RecyclerView.ViewHolder {

        TextView id, fullname, contacts, email, course, fees;
        MaterialButton update, delete;

        public Dataholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            fullname = itemView.findViewById(R.id.fullname);
            contacts = itemView.findViewById(R.id.contacts);
            email = itemView.findViewById(R.id.email);
            course = itemView.findViewById(R.id.course);
            fees = itemView.findViewById(R.id.fees);

            update = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
