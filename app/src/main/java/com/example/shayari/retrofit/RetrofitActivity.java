package com.example.shayari.retrofit;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayari.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    RecyclerView rt_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        rt_recycle = findViewById(R.id.rt_recycle);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {

            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

            apiInterface.getImage().enqueue(new Callback<List<RetrofitModel>>() {
                @Override
                public void onResponse(Call<List<RetrofitModel>> call, Response<List<RetrofitModel>> response) {


                    if (response.isSuccessful()) {

                        List<RetrofitModel> datalist = response.body();
                        rt_recycle.setLayoutManager(new LinearLayoutManager(RetrofitActivity.this));
                        rt_recycle.setAdapter(new RetrofitAdapter(RetrofitActivity.this, datalist));
                    }
                }

                @Override
                public void onFailure(Call<List<RetrofitModel>> call, Throwable t) {


                }
            });
        }
        else{
            Toast.makeText(RetrofitActivity.this, "No Internet  ", Toast.LENGTH_SHORT).show();
        }

    }
}