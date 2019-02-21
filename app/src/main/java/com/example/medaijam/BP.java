package com.example.medaijam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BP extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bp);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new BPFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch(item.getItemId()) {
            case R.id.navigation_bp:
                fragment = new BPFragment();
                break;

            case R.id.navigation_hr:
                fragment = new HRFragment();
                break;

            case R.id.navigation_breathing:
                fragment = new BreathingFragment();
                break;

            case R.id.navigation_enter:
                fragment = new EnterFragment();
                break;
        }
        return loadFragment(fragment);
    }

}
