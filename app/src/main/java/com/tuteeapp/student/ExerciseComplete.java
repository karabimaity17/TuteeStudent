package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ExerciseComplete extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    BottomNavigationView bottom_navigationView;
    Button classroom,test_exam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_complete);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottom_navigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        classroom = findViewById(R.id.classroom);
        test_exam = findViewById(R.id.test_exam);

        test_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExerciseComplete.this,TestExamLibrary.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        classroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExerciseComplete.this,Classroom.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        drawerToggle.setHomeAsUpIndicator(R.drawable.toggle);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(ExerciseComplete.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ExerciseComplete.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ExerciseComplete.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ExerciseComplete.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ExerciseComplete.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ExerciseComplete.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ExerciseComplete.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
        bottom_navigationView.getMenu().getItem(3).setIcon(R.drawable.classroom2);
        bottom_navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setTitle("Home");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    bottom_navigationView.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ExerciseComplete.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottom_navigationView.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ExerciseComplete.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(ExerciseComplete.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottom_navigationView.getMenu().getItem(3).setIcon(R.drawable.classroom);
                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(ExerciseComplete.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottom_navigationView.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ExerciseComplete.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

                return true;
            }
        });
       // bottom_navigationView.setSelectedItemId(R.id.menu_classroom);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer_layout = findViewById(R.id.drawer_layout);

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.shop) {
            Intent i1 = new Intent(ExerciseComplete.this, CartActivity.class);
            startActivity(i1);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return true;
        }else if(id == R.id.bell){
            Intent i1 = new Intent(ExerciseComplete.this, ExerciseReport.class);
            startActivity(i1);
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            applyOverrideConfiguration(override);
        }
    }

}