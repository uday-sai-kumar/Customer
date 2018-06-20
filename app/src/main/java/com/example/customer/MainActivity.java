package com.example.customer;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
BottomNavigationView navigationView;
FrameLayout frameLayout;
FragmentHome fragmentHome;
FragmentIssue fragmentIssue;
FragmentStatus fragmentStatus;
FragmentFeedback fragmentFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.bottomnavigation);
        BottomNavigationViewHelper.diableShiftMode(navigationView);
        fragmentHome=new FragmentHome();
        frameLayout=findViewById(R.id.frame);
        fragmentStatus=new FragmentStatus();
        fragmentIssue=new FragmentIssue();
        fragmentFeedback=new FragmentFeedback();
        navigationView.setSelectedItemId(R.id.home);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragmentHome).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:{
                    calFrag(fragmentHome);
                    return true;
                    }
                    case R.id.issue:{
                        calFrag(fragmentIssue);
                        return true;
                    }
                    case R.id.status:{
                        calFrag(fragmentStatus);
                        return true;
                    }
                    case R.id.feedback:{
                        calFrag(fragmentFeedback);
                        return true;
                    }
                }
                return false;
            }
        });

    }

    private void calFrag(Fragment fragmentHome) {
       FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
       transaction.replace(R.id.frame,fragmentHome).commit();


    }
}
