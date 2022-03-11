package com.example.shayari.retrofit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.R;

import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.Dataholder> {

    Activity activity;
    List<RetrofitModel> datalist;
    public RetrofitAdapter(Activity activity, List<RetrofitModel> datalist) {

        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(activity).inflate(R.layout.asdfg,parent,false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, int position) {


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

    class Dataholder extends RecyclerView.ViewHolder {

        TextView id, name, email, gender, status;

        public Dataholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            gender = itemView.findViewById(R.id.gender);
            status = itemView.findViewById(R.id.status);
        }
    }
}
