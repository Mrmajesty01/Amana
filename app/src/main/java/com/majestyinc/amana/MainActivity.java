package com.majestyinc.amana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FragmentHome()).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener onNav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selected = null;

            switch (item.getItemId()) {


                case R.id.home_bottom:
                    selected = new FragmentHome();
                    break;



                case R.id.history_bottom:
                    selected = new FragmentHistory();
                    break;



                case R.id.profile_bottom:
                    selected = new FragmentProfile();
                    break;







            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selected).commit();
            return true;


        }
    };

}

