package com.example.movieapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.movieapplication.Fragments.RetailerAboutFragment;
import com.example.movieapplication.Fragments.RetailerDashboardFragment;
import com.example.movieapplication.Fragments.RetailerHelpFragment;
import com.example.movieapplication.Fragments.RetailerManageFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class UserDashboard extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);
        chipNavigationBar=findViewById(R.id.dashboard_bott_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bott_nav_dashboard,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_dashboard_container,new RetailerDashboardFragment( )).commit();

        bottom_menu();
    }


    private void bottom_menu() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i)
                {
                    case R.id.bott_nav_dashboard:
                        fragment=new RetailerDashboardFragment();
                        break;
                    case R.id.bott_nav_manage:
                        fragment=new RetailerManageFragment();
                        break;
                    case R.id.bott_nav_help:
                        fragment=new RetailerHelpFragment();
                        break;
                    case R.id.bott_nav_about:
                        fragment=new RetailerAboutFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_dashboard_container,fragment).commit();
            }

        });
    }
}