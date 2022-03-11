package com.example.shayari.delete2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.shayari.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class deleteActivity extends AppCompatActivity {

    ImageView image;
    TextView id, title, price, description, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        image = findViewById(R.id.image);
        id = findViewById(R.id.id);
        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        category = findViewById(R.id.category);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {

            ApiInterfaces apiInterfaces = ApiClients.getApiClients().create(ApiInterfaces.class);
            apiInterfaces.getInterfaces().enqueue(new Callback<deleteModel>() {
                @Override
                public void onResponse(Call<deleteModel> call, Response<deleteModel> response) {

                    deleteModel datalist = response.body();
                    id.setText(datalist.id + "");
                    title.setText(datalist.title);
                    price.setText(datalist.price + "");
                    description.setText(datalist.description);
                    category.setText(datalist.category);
                    Glide.with(deleteActivity.this).load(datalist.image).into(image);

                    Toast.makeText(deleteActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<deleteModel> call, Throwable t) {
                    Toast.makeText(deleteActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}