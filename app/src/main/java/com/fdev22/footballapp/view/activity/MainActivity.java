package com.fdev22.footballapp.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.fdev22.footballapp.view.fragment.AboutFragment;
import com.fdev22.footballapp.view.fragment.PredictionFragment;
import com.fdev22.footballapp.view.fragment.FootballFragment;
import com.fdev22.footballapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedFragment = new FootballFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_bottomnav_football:
                selectedFragment = new FootballFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_prediction:
                selectedFragment = new PredictionFragment();
                loadFragment(selectedFragment);
                break;

            case R.id.menu_bottomnav_about:
                selectedFragment=new AboutFragment();
                loadFragment(selectedFragment);
                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragmentcontainer, selectedFragment)
                    .commit();
            return true;
        }
        return false;
    }
}
