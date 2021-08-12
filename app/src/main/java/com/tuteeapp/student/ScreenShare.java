package com.tuteeapp.student;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.tuteeapp.student.Fragment.All_ScreenShareFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ScreenShare extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    BottomNavigationView bottomnav;

    LinearLayout lin_teacher,lin_chat,lin_screen_share,lin_group,linear_screen;
    LinearLayout cardsearch;
    CardView card_screen_1,card_screen_2;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_share);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navview);
        bottomnav = (BottomNavigationView) findViewById(R.id.bottomnav);
    //    myDialog = new Dialog(this);

        lin_teacher = findViewById(R.id.lin_teacher);
        lin_chat = findViewById(R.id.lin_chat);
        lin_screen_share = findViewById(R.id.lin_screen_share);
        lin_group = findViewById(R.id.lin_group);
      //  cardsearch = findViewById(R.id.cardsearch);
        linear_screen = findViewById(R.id.linear_screen);

        card_screen_1 = findViewById(R.id.card_screen_1);
        card_screen_2 = findViewById(R.id.card_screen_2);

        linear_screen.setVisibility(View.VISIBLE);

        lin_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenShare.this,ChatActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        lin_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenShare.this,MyTeacher.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        lin_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenShare.this,Group.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        card_screen_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ScreenShare.this,AttendClass.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        card_screen_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(ScreenShare.this,AttendClass.class));
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
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(ScreenShare.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ScreenShare.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ScreenShare.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ScreenShare.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ScreenShare.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ScreenShare.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ScreenShare.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher2);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setTitle("Home");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(ScreenShare.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(ScreenShare.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    startActivity(new Intent(ScreenShare.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));

                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(ScreenShare.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(ScreenShare.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shop:
                Intent i1 = new Intent(ScreenShare.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ScreenShare .this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        final Configuration override = new Configuration(newBase.getResources().getConfiguration());
        override.fontScale = 1.0f;
        applyOverrideConfiguration(override);
    }
}