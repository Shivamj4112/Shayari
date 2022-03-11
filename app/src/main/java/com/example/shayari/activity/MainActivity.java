package com.example.shayari.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shayari.adapter.DataAdapter;
import com.example.shayari.R;
import com.example.shayari.delete2.deleteActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    RecyclerView Recycleview;
    ImageView arrow_forward;

    DrawerLayout drawer;
    NavigationView navigation;
    ImageView menu;

    LinearLayout layout,actionbar;

    String[] Shayari = new String[]{"Bhare Bazaar Se Aksar Main Khali Haath Aaya Hoon,\n" +
                                    "Kabhi Khwahish Nahi Hoti Kabhi Paise Nahi Hote"

                                    ,"Talab Karein To Main Apni Aankhein Bhi Unhe De Du,\n" +
                                    "Magar Ye Log Meri Aankhon Ke Khwab Maangte Hain."

                                    ,"Main Ek Shaam Jo Roshan Deeya Uthha Laya,\n" +
                                    "Tamaam Shahar Kahin Se Hawa Uthha Laya."

                                    ,"Najron Mein Doston Ki Jo Itna Kharab Hai,\n" +
                                    "Uska Qasoor Ye Hai Ki Wo Kaamyab Hai."

                                    ,"Sitam To Ye Hai Ke Zalim Sukhan-Sanaas Nahin,\n" +
                                    "Wo Ek Shakhs Jo Shayar Banaa Gaya Mujhko."

                                    ,"Sher-o-Sukhan Kya Koi Bachchon Ka Khel Hai?\n" +
                                    "Jal Jaati Hain Jawaniyan Lafzon Ki Aag Mein."

                                    ,"Chehre Par Sukoon To Bas Dikhaane Bhar Ka Hai,\n" +
                                    "Varna Bechain To Har Shakhs Zamane Bhar Ka Hai."

                                    ,"हाल जब भी पूछो खैरियत बताते हो,\n" +
                                     "लगता है मोहब्बत छोड़ दी तुमने।"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Recycleview = findViewById(R.id.Recycleview);
        arrow_forward = findViewById(R.id.arrow_forward);

        drawer = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        menu = findViewById(R.id.menu);

        layout = findViewById(R.id.layout);
        actionbar = findViewById(R.id.actionbar);

        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null && info.isConnected()){

            actionbar.setVisibility(View.VISIBLE);

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    drawer.openDrawer(Gravity.LEFT);
                }
            });

            navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {

                        case R.id.fragmet:
                            startActivity(new Intent(MainActivity.this, FragmentActivity.class));
                            break;
                        case R.id.dynamic_fragment:
                            startActivity(new Intent(MainActivity.this, Dynamic_FragmentActivity.class));
                            break;
                        case R.id.date_and_time:
                            startActivity(new Intent(MainActivity.this, Date_and_time_Activity.class));
                            break;
                        case R.id.image_slider:
                            startActivity(new Intent(MainActivity.this, image_slider_Activity.class));
                            break;
                        case R.id.viewslider:
                            startActivity(new Intent(MainActivity.this, viewpager_fragment_Activity.class));
                            break;
                        case R.id.tablayout:
                            startActivity(new Intent(MainActivity.this, TabLayout_Activity.class));
                            break;
                        case R.id.navigation_drawer:
                            startActivity(new Intent(MainActivity.this, Navigation_drawerActivity.class));
                            break;
                        case R.id.database1:
                            startActivity(new Intent(MainActivity.this, DatabaseTask1Activity.class));
                            break;
                        case R.id.database2:
                            startActivity(new Intent(MainActivity.this, DatabaseTask2Activity.class));
                            break;
                        case R.id.database3:
                            startActivity(new Intent(MainActivity.this, DatabaseTask3Activity.class));
                            break;
                        case R.id.volly_api:
                            startActivity(new Intent(MainActivity.this, VolleyApiActivity.class));
                            break;
                        case R.id.retrofit:
                            startActivity(new Intent(MainActivity.this, deleteActivity.class));
                            break;

                    }
                    return false;
                }
            });

            arrow_forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(MainActivity.this,FragmentActivity.class));
                    finish();
                }
            });
            Recycleview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            Recycleview.setAdapter(new DataAdapter(MainActivity.this,Shayari));

        }
        else{

            Snackbar snackbar = Snackbar.make(layout,"No Internet Connection !!!",Snackbar.LENGTH_INDEFINITE)
                    .setAction("retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                            NetworkInfo info = manager.getActiveNetworkInfo();

                            if (info != null && info.isConnected()){

                                actionbar.setVisibility(View.VISIBLE);

                                menu.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        drawer.openDrawer(Gravity.LEFT);
                                    }
                                });

                                navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                    @Override
                                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                                        switch (item.getItemId()) {

                                            case R.id.fragmet:
                                                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
                                                break;
                                            case R.id.dynamic_fragment:
                                                startActivity(new Intent(MainActivity.this, Dynamic_FragmentActivity.class));
                                                break;
                                            case R.id.date_and_time:
                                                startActivity(new Intent(MainActivity.this, Date_and_time_Activity.class));
                                                break;
                                            case R.id.image_slider:
                                                startActivity(new Intent(MainActivity.this, image_slider_Activity.class));
                                                break;
                                            case R.id.viewslider:
                                                startActivity(new Intent(MainActivity.this, viewpager_fragment_Activity.class));
                                                break;
                                            case R.id.tablayout:
                                                startActivity(new Intent(MainActivity.this, TabLayout_Activity.class));
                                                break;
                                            case R.id.navigation_drawer:
                                                startActivity(new Intent(MainActivity.this, Navigation_drawerActivity.class));
                                                break;
                                            case R.id.database1:
                                                startActivity(new Intent(MainActivity.this, DatabaseTask1Activity.class));
                                                break;
                                            case R.id.database2:
                                                startActivity(new Intent(MainActivity.this, DatabaseTask2Activity.class));
                                                break;
                                            case R.id.database3:
                                                startActivity(new Intent(MainActivity.this, DatabaseTask3Activity.class));
                                                break;
                                            case R.id.volly_api:
                                                startActivity(new Intent(MainActivity.this, VolleyApiActivity.class));
                                                break;
                                            case R.id.retrofit:
                                                startActivity(new Intent(MainActivity.this, deleteActivity.class));
                                                break;

                                        }
                                        return false;
                                    }
                                });

                                arrow_forward.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        startActivity(new Intent(MainActivity.this,FragmentActivity.class));
                                        finish();
                                    }
                                });
                                Recycleview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                Recycleview.setAdapter(new DataAdapter(MainActivity.this,Shayari));

                            }
                            else{
                                Snackbar snackbar1 = Snackbar.make(layout,"NO Internet Connection !!!",Snackbar.LENGTH_INDEFINITE)
                                        .setAction("retry", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                            }
                                        });
                                snackbar1.show();
                            }
                        }
                    });

            snackbar.show();
        }
    }
}