package com.example.newsapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.newsapp.R;

import com.example.newsapp.fragments.BBC;
import com.example.newsapp.fragments.CNN;
import com.example.newsapp.ui.dainikbhaskar.HomeFragment;
import com.example.newsapp.ui.gallery.GalleryFragment;
import com.example.newsapp.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       setSupportActionBar(binding.appBarMain.toolbar);

//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null)
//                        .setAnchorView(R.id.fab).show();
//            }
//        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Set up the AppBarConfiguration with the menu IDs
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.dbn, R.id.td, R.id.dead, R.id.bbc, R.id.cnn)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Set up ActionBar with NavController and AppBarConfiguration
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Use if-else to handle navigation with NavController
                if (id == R.id.dbn) {
                    Toast.makeText(MainActivity.this, "Dainik Bhaskar clicked", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.dbn);
                } else if (id == R.id.td) {
                    Toast.makeText(MainActivity.this, "The Direct clicked", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.td);
                } else if (id == R.id.dead) {
                    Toast.makeText(MainActivity.this, "Deadline News clicked", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.dead);
                } else if (id == R.id.bbc) {
                    Toast.makeText(MainActivity.this, "BBC clicked", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.bbc);
                } else if (id == R.id.cnn) {
                    Toast.makeText(MainActivity.this, "CNN clicked", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.cnn);
                } else {
                    return false;
                }

                // Close the navigation drawer after an item is selected
                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
