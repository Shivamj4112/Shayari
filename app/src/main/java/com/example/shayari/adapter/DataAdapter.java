package com.example.shayari.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.R;
import com.example.shayari.activity.MainActivity;

import java.util.Locale;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Dataholder>{

    Activity activity;
    String shayri[];
    TextToSpeech textToSpeech;
    public DataAdapter(MainActivity mainActivity, String[] shayari) {

        activity = mainActivity;
        this.shayri = shayari;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.recycle,parent,false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, @SuppressLint("RecyclerView") int position) {

        holder.text.setText(shayri[position]);

        textToSpeech = new TextToSpeech(activity, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if (i != TextToSpeech.ERROR){


                }
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                View customLayout = LayoutInflater.from(activity).inflate(R.layout.custom_dialog, null);
                builder.setView(customLayout);

                Button Hindi = customLayout.findViewById(R.id.Hindi);
                Button English = customLayout.findViewById(R.id.English);

                Hindi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        textToSpeech.setLanguage(new Locale ("hi","IN"));
                        textToSpeech.speak(shayri[position],TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(activity, "Hindi voice", Toast.LENGTH_SHORT).show();


                    }
                });

                English.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        textToSpeech.setLanguage(Locale.ENGLISH);
                        textToSpeech.speak(shayri[position],TextToSpeech.QUEUE_FLUSH,null);
                        Toast.makeText(activity, "English voice", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return shayri.length;
    }

    class Dataholder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;
        public Dataholder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            image = itemView.findViewById(R.id.Texttospeech);
        }
    }
}
