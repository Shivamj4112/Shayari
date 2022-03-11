package com.example.shayari.delete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shayari.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class asdfghActivity extends AppCompatActivity {

    List<model> datalist = new ArrayList<>();
    String url = "https://gorest.co.in/public/v2/users";
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asdfgh);

        list = findViewById(R.id.list);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        int id = object.getInt("id");
                        String name = object.getString("name");
                        String email = object.getString("email");
                        String gender = object.getString("gender");
                        String status = object.getString("status");

                        model m = new model(id,name ,email,gender,status);
                        datalist.add(m);

                        list.setLayoutManager(new LinearLayoutManager(asdfghActivity.this));
                        list.setAdapter(new adapeter(asdfghActivity.this,datalist));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(asdfghActivity.this, ""+error, Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(asdfghActivity.this);
        queue.add(request);

    }
}