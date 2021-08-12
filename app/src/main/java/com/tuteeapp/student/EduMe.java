package com.tuteeapp.student;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.tuteeapp.student.Adapter.Recyclehomeadapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tuteeapp.student.Fragment.SubjectFragment;
import com.tuteeapp.student.Model.AllModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class EduMe extends AppCompatActivity {

    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomnav;

    ViewPager viewpagerfrag;
    TabLayout tabLayout;
    RecyclerView rvhome;
    int[] tabIcon = {R.drawable.book, R.drawable.math, R.drawable.physics, R.drawable.english, R.drawable.chemistry};
    ArrayList<AllModel> arrayList = new ArrayList<>();
    Dialog myDialog;
    ImageView imagevideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edume);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        bottomnav = findViewById(R.id.bottomnav);

        myDialog = new Dialog(EduMe.this);
        viewpagerfrag = findViewById(R.id.viewpagerfrag);
        imagevideo=findViewById(R.id.imagevideo);
        tabLayout = findViewById(R.id.tablayout);
        rvhome = findViewById(R.id.rvhome);


        tabLayout.setupWithViewPager(viewpagerfrag);
        viewpagerfrag.setAdapter(new Subjectadapter(getSupportFragmentManager()));

        arrayList.add(new AllModel(R.drawable.image1));
        arrayList.add(new AllModel(R.drawable.image2));
        arrayList.add(new AllModel(R.drawable.image5));
        rvhome.setAdapter(new Recyclehomeadapter(arrayList,EduMe.this));


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
                        Intent i1 = new Intent(EduMe.this, EduMe.class);
                        startActivity(i1);
                        finish();

                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(EduMe.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(EduMe.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(EduMe.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(EduMe.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(EduMe.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(EduMe.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
        bottomnav.getMenu().getItem(0).setIcon(R.drawable.home2);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    menuItem.setTitle("Home");

                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    startActivity(new Intent(EduMe.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(EduMe.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                }else if(id== R.id.menu_classroom){

                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    startActivity(new Intent(EduMe.this,Classroom.class));
                    menuItem.setTitle("Classroom");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    startActivity(new Intent(EduMe.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }

                return true;
            }
        });
        bottomnav.setSelectedItemId(R.id.menu_home);

    }

    public class Subjectadapter extends FragmentStatePagerAdapter {
        public Subjectadapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment f = null;

            if (position == 0) {
                f = new SubjectFragment();
            }
            if (position == 1) {
                f = new SubjectFragment();
            }
            if (position == 2) {
                f = new SubjectFragment();
            }
            if (position == 3) {
                f = new SubjectFragment();
            }
            if (position == 4) {
                f = new SubjectFragment();
            }
            return f;
        }

        @Override
        public int getCount() {
            return 5;
        }
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
                Intent i1 = new Intent(EduMe.this, CartActivity.class);
                startActivity(i1);
                return true;
            case R.id.bell:
                Intent i2 = new Intent(EduMe.this, Notification.class);
                startActivity(i2);
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