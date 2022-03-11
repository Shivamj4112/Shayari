package com.example.shayari.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shayari.R;
import com.example.shayari.adapter.DataAdapter;
import com.example.shayari.volley_recycle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VolleyApiActivity extends AppCompatActivity {

    List<volleyModel> datalist = new ArrayList<>();
    RecyclerView list;
    String url = "https://gorest.co.in/public/v2/todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_api);

        list = findViewById(R.id.list);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        int id = object.getInt("id");
                        int user_id = object.getInt("user_id");
                        String title = object.getString("title");
                        String due_on = object.getString("due_on");
                        String status = object.getString("status");

                        volleyModel data = new volleyModel(id,user_id,title,due_on,status);
                        datalist.add(data);

                        list.setLayoutManager(new LinearLayoutManager(VolleyApiActivity.this));
                        list.setAdapter(new volley_recycle(VolleyApiActivity.this,datalist));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyApiActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue que = Volley.newRequestQueue(VolleyApiActivity.this);
        que.add(request);
    }
}