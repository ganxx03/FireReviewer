package com.example.firereviewer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.firereviewer.ui.gallery.GalleryFragment;
import com.example.firereviewer.ui.home.HomeFragment;
import com.example.firereviewer.ui.slideshow.SlideshowFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firereviewer.databinding.ActivityNavigationBinding;

public class NavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    TextView tvHeader;
    SharedPreferences sp;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sp = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);




        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigation.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_reviewer, R.id.nav_examsimulator, R.id.nav_pdfreviewer, R.id.nav_dateofexam, R.id.nav_about)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        tvHeader = findViewById(R.id.tvHeader1);
        String name = sp.getString(KEY_NAME,null);
        if(name!=null){
            tvHeader.setText(name);
        }
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void onBackPressed(){
        NavigationView navigationView = binding.navView;
        if(navigationView.getMenu().getItem(0).isChecked()){
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
        else{
            this.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_navigation, new HomeFragment()).commit();
            navigationView.getMenu().getItem(0).setChecked(true);
            this.getSupportActionBar().setTitle("Home");
        }
    }


}