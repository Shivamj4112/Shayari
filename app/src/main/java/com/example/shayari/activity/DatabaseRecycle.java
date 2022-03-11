package com.example.shayari.activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.Database1_Model;
import com.example.shayari.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class DatabaseRecycle extends RecyclerView.Adapter<DatabaseRecycle.Dataholder> {


    Activity activity;
    List<Database1_Model> datalist;

    public DatabaseRecycle(Activity activity, List<Database1_Model> datalist) {

        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.database_layout, parent, false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, int position) {

        holder.id.setText(datalist.get(position).id+"");
        holder.fullname.setText(datalist.get(position).fullname);
        holder.contacts.setText(datalist.get(position).contacts);
        holder.email.setText(datalist.get(position).email);
        holder.course.setText(datalist.get(position).course);
        holder.fees.setText(datalist.get(position).fees);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class Dataholder extends RecyclerView.ViewHolder {

        TextView id, fullname, contacts, email, course, fees;

        public Dataholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            fullname = itemView.findViewById(R.id.fullname);
            contacts = itemView.findViewById(R.id.contacts);
            email = itemView.findViewById(R.id.email);
            course = itemView.findViewById(R.id.course);
            fees = itemView.findViewById(R.id.fees);
        }
    }
}
