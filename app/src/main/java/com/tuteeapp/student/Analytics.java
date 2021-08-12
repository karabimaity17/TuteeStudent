package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class Analytics extends AppCompatActivity {
    Button viewreport,test_exam;
    CardView card1;
    LinearLayout lin_badges;

    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        bottomnav = findViewById(R.id.bottomnav);
        viewreport = findViewById(R.id.viewreport);
        card1 = findViewById(R.id.card1);
        test_exam = findViewById(R.id.test_exam);
        lin_badges = findViewById(R.id.lin_badges);
        //final Intent intent = new Intent(Analytics.this, ExerciseLibrary.class);

        viewreport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analytics.this,ReportActivity.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analytics.this,ChapterLibrary.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });

        test_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analytics.this,TestExamLibrary.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });

        lin_badges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Analytics.this,MyBadges.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        drawerToggle.setHomeAsUpIndicator(R.drawable.toggle);
        navview.setItemIconTintList(null);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(Analytics.this, EduMe.class);
                        startActivity(i1);
                        finish();

                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(Analytics.this, EditProfile.class);
                        startActivity(i2);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(Analytics.this, ConnectDesktop.class);
                        startActivity(i3);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(Analytics.this, FeedbackActivity.class);
                        startActivity(i4);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(Analytics.this, MyAccount.class);
                        startActivity(i5);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(Analytics.this, ContactUs.class);
                        startActivity(i6);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(Analytics.this, Settings.class));
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
        bottomnav.getMenu().getItem(1).setIcon(R.drawable.analytics2);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setTitle("Home");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    bottomnav.getMenu().getItem(1).setIcon(R.drawable.analytics);
                    startActivity(new Intent(Analytics.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(Analytics.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(1).setIcon(R.drawable.analytics);
                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));
                    bottomnav.getMenu().getItem(1).setIcon(R.drawable.analytics);
                    startActivity(new Intent(Analytics.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(1).setIcon(R.drawable.analytics);
                    startActivity(new Intent(Analytics.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

                return true;
            }
        });
        bottomnav.setSelectedItemId(R.id.menu_analytic);

    }
    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shop:
                Intent i1 = new Intent(Analytics.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(Analytics .this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        final Configuration override = new Configuration(newBase.getResources().getConfiguration());
        override.fontScale = 1.0f;
        applyOverrideConfiguration(override);
    }
}