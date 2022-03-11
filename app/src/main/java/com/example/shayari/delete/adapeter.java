package com.example.shayari.delete;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.R;

import java.util.List;

public class adapeter extends RecyclerView.Adapter<adapeter.dataholder> {

    Activity activity;
    List<model> datalist;
    public adapeter(Activity activity, List<model> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.asdfg,parent,false);
        return new dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataholder holder, int position) {

        holder.id.setText(datalist.get(position).id+"");
        holder.name.setText(datalist.get(position).name);
        holder.email.setText(datalist.get(position).email);
        holder.gender.setText(datalist.get(position).gender);
        holder.status.setText(datalist.get(position).status);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class dataholder extends RecyclerView.ViewHolder{

        TextView id, name, email, gender, status;
        public dataholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            gender = itemView.findViewById(R.id.gender);
            status = itemView.findViewById(R.id.status);
        }
    }
}
