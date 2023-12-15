package com.example.myapplication;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView;
        navigationView = findViewById(R.id.navigation_view);

        // Set a listener for navigation item selection
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                // Replace content view with Home fragment
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.nav_profile) {
                // Replace content view with Profile fragment
                replaceFragment(new ProfileFragment());
            } else if (itemId == R.id.nav_settings) {
                // Replace content view with Settings fragment
                replaceFragment(new SettingsFragment());
            }
            // Close the drawer after selecting an item
            drawerLayout.closeDrawer(GravityCompat.START);

            // Return true to indicate the item is handled
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_view, fragment);
        transaction.commit();
    }
}
