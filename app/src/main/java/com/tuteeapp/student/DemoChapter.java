package com.tuteeapp.student;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.tuteeapp.student.Adapter.DemoFragmentAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DemoChapter extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomnav;

    ViewPager viewpager14;
    TabLayout tabLayout;
    Button btnupgrade;
    ImageView img_back, imagevideo;
    TextView textfeedback;
    Dialog myDialog;
    int[] tabIcon = {R.drawable.book, R.drawable.math, R.drawable.physics, R.drawable.english, R.drawable.chemistry};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_chapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        bottomnav = findViewById(R.id.bottomnav);
        img_back = findViewById(R.id.img_back);

        myDialog = new Dialog(DemoChapter.this);
        imagevideo = findViewById(R.id.imagevideo);
        img_back = findViewById(R.id.img_back);
        viewpager14 = findViewById(R.id.viewpager14);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewpager14);
        btnupgrade = findViewById(R.id.btnupgrade);

        textfeedback = findViewById(R.id.textfeedback);

        viewpager14.setAdapter(new DemoFragmentAdapter(getSupportFragmentManager()));
        tabLayout.getTabAt(0).setIcon(tabIcon[0]);
        tabLayout.getTabAt(0).setText("All");
        tabLayout.getTabAt(1).setIcon(tabIcon[1]);
        tabLayout.getTabAt(1).setText("Maths");
        tabLayout.getTabAt(2).setIcon(tabIcon[2]);
        tabLayout.getTabAt(2).setText("Physics");
        tabLayout.getTabAt(3).setIcon(tabIcon[3]);
        tabLayout.getTabAt(3).setText("English");
        tabLayout.getTabAt(4).setIcon(tabIcon[4]);
        tabLayout.getTabAt(4).setText("Chemistry");

        imagevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* CardView cardpopup;
                myDialog.setContentView(R.layout.popup364);
                cardpopup = myDialog.findViewById(R.id.cardpopup);
                cardpopup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();*/
            }

        });
        btnupgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemoChapter.this, EnterDetails.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        textfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemoChapter.this, FeedbackActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        // for back button //
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(DemoChapter.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(DemoChapter.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(DemoChapter.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(DemoChapter.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(DemoChapter.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(DemoChapter.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(DemoChapter.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
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
                Intent i1 = new Intent(DemoChapter.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(DemoChapter .this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
        }

        return super.onOptionsItemSelected(item);
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
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        final Configuration override = new Configuration(newBase.getResources().getConfiguration());
        override.fontScale = 1.0f;
        applyOverrideConfiguration(override);
    }

}