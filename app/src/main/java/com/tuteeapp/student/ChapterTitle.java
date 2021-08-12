package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.tuteeapp.student.Adapter.PageAdapter;
import com.tuteeapp.student.Model.AllModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChapterTitle extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    public ImageView img_back;
    BottomNavigationView bottomnav;

    RecyclerView rv_page;
    LinearLayout lin_comment;
    TextView back,next;
    private static int currentPage = 0;
    ArrayList<AllModel> arrayList = new ArrayList();
    PageAdapter pageAdapter;
    PageAdapter.callback indicatorCallback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_title);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Chapter");

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        img_back = findViewById(R.id.img_back);
        bottomnav = findViewById(R.id.bottomnav);
        rv_page = findViewById(R.id.rv_page);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        lin_comment = findViewById(R.id.lin_comment);

        arrayList.add(new AllModel("1"));
        arrayList.add(new AllModel("2"));
        arrayList.add(new AllModel("3"));
        arrayList.add(new AllModel("4"));
        arrayList.add(new AllModel("5"));
        arrayList.add(new AllModel("6"));
        arrayList.add(new AllModel("7"));
        arrayList.add(new AllModel("8"));
        currentPage=arrayList.size();
        indicatorCallback = new PageAdapter.callback() {
            @Override
            public void onTitleClicked(int position) {
                currentPage = position;
               // Toast.makeText(ChapterTitle.this, ""+currentPage, Toast.LENGTH_SHORT).show();
                if (currentPage < arrayList.size()) {
                    pageAdapter.setSelectedIndex(currentPage);
                    pageAdapter.notifyDataSetChanged();
                    rv_page.scrollToPosition(currentPage);
                }else {
                    next.setVisibility(View.GONE);
                }
            }
        };
        pageAdapter = new PageAdapter(ChapterTitle.this,arrayList,indicatorCallback);
        rv_page.setAdapter(pageAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (currentPage > 0) {
                    currentPage = currentPage-1;
                    Toast.makeText(ChapterTitle.this, ""+currentPage, Toast.LENGTH_SHORT).show();
                    pageAdapter.setSelectedIndex(currentPage);
                    pageAdapter.notifyDataSetChanged();
                    rv_page.scrollToPosition(currentPage);
                }else if (currentPage == arrayList.size()){
                    next.setVisibility(View.GONE);
                }


            }
        });
        lin_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChapterTitle.this, Comments.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
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

        navview.setItemIconTintList(null);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(ChapterTitle.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();

                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ChapterTitle.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ChapterTitle.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ChapterTitle.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ChapterTitle.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ChapterTitle.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ChapterTitle.this, Settings.class));
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
                    startActivity(new Intent(ChapterTitle.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    menuItem.setTitle("Home");

                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    startActivity(new Intent(ChapterTitle.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(ChapterTitle.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                }else if(id== R.id.menu_classroom){

                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    startActivity(new Intent(ChapterTitle.this,Classroom.class));
                    menuItem.setTitle("Classroom");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    startActivity(new Intent(ChapterTitle.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

                return true;
            }
        });
        //bottomnav.setSelectedItemId(R.id.menu_home);
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
                Intent i1 = new Intent(ChapterTitle.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ChapterTitle .this, Notification.class));
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