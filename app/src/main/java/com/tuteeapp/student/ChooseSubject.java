package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.tuteeapp.student.Adapter.ChooseSubAdapter;
import com.tuteeapp.student.Model.Model_Choosesub;
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
import android.widget.Button;

import java.util.ArrayList;

public class ChooseSubject extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;

    Button btnnext;
    RecyclerView rvsubject;
    ArrayList<Model_Choosesub> alist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_subject);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Choose\nYour Subject");
        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);

        btnnext = findViewById(R.id.btnnext);
        rvsubject = findViewById(R.id.rvsubject);

        alist.add(new Model_Choosesub("English"));
        alist.add(new Model_Choosesub("Mathematics"));
        alist.add(new Model_Choosesub("Physics"));
        alist.add(new Model_Choosesub("Chemistry"));
        alist.add(new Model_Choosesub("Biology"));
        alist.add(new Model_Choosesub("Social Science"));
        alist.add(new Model_Choosesub("Histroy"));
        alist.add(new Model_Choosesub("General knowledge"));

        rvsubject.setAdapter(new ChooseSubAdapter(alist));
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseSubject.this, InitailizingActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


    drawerToggle =new ActionBarDrawerToggle(this,drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

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
        public boolean onNavigationItemSelected (@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.menu_home:
                Intent i1 = new Intent(ChooseSubject.this, EduMe.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_profile:
                Intent i2 = new Intent(ChooseSubject.this, EditProfile.class);
                startActivity(i2);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_desktop:
                Intent i3 = new Intent(ChooseSubject.this, ConnectDesktop.class);
                startActivity(i3);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_feedback:
                Intent i4 = new Intent(ChooseSubject.this, FeedbackActivity.class);
                startActivity(i4);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_account:
                Intent i5 = new Intent(ChooseSubject.this, MyAccount.class);
                startActivity(i5);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_contact:
                Intent i6 = new Intent(ChooseSubject.this, ContactUs.class);
                startActivity(i6);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_settings:
                startActivity(new Intent(ChooseSubject.this, Settings.class));
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
                Intent i1 = new Intent(ChooseSubject.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ChooseSubject .this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        final Configuration override = new Configuration(newBase.getResources().getConfiguration());
        override.fontScale = 1.0f;
        applyOverrideConfiguration(override);
    }
}