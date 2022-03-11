package com.example.shayari;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.activity.volleyModel;

import java.util.List;

public class volley_recycle extends RecyclerView.Adapter<volley_recycle.dataholder>{

    Activity activity;
    List<volleyModel> datalist;
    public volley_recycle(Activity activity, List<volleyModel> datalist) {

        this.activity = activity;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.datavolley,parent,false);
        return new dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dataholder holder, int position) {

        holder.id.setText(datalist.get(position).id+"");
        holder.user_id.setText(datalist.get(position).user_id+"");
        holder.title.setText(datalist.get(position).title);
        holder.due_on.setText(datalist.get(position).due_on);
        holder.status.setText(datalist.get(position).status);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class dataholder extends RecyclerView.ViewHolder{

        TextView id, user_id, title, due_on, status;
        public dataholder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            user_id = itemView.findViewById(R.id.user_id);
            title = itemView.findViewById(R.id.title);
            due_on = itemView.findViewById(R.id.due_on);
            status = itemView.findViewById(R.id.status);
        }
    }
}
