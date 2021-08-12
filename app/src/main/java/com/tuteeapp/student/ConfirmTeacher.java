package com.tuteeapp.student;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class ConfirmTeacher extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    public ImageView img_back;

    Button btnaddteach, btndemo, btnadd;
    CardView cardsearch;
    CheckBox check1, check2, check3;
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_teacher);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Confirm Your\nTeacher");


        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        img_back = findViewById(R.id.img_back);

        btnaddteach = findViewById(R.id.btnaddteach);
        btndemo = findViewById(R.id.btndemo);
        btnadd = findViewById(R.id.btnadd);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        cardsearch = findViewById(R.id.cardsearch);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnadd.setBackgroundResource(R.drawable.btnblue_background);
                btnadd.setTextColor(getApplication().getResources().getColor(R.color.white));
            }
        });
        btnaddteach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmTeacher.this, CartActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        btndemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmTeacher.this, ViewDemo.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(ConfirmTeacher.this, ChooseSubject.class);
//                startActivity(i);
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportActionBar().setTitle("Advanced Search");
                CardView cardsearching;
                MaterialBetterSpinner spinboard, spinsyllabus, spinsubject, spinnation, spincountry;
                String Board[] = {"India", "USA"};
                String Syllabus[] = {"CBSC", "ICSE"};
                String Subject[] = {"English", "History"};
                String Nation[] = {"India", "USA"};
                String Country[] = {"India", "USA"};
                myDialog.setContentView(R.layout.search);
                cardsearching = myDialog.findViewById(R.id.cardsearching);
                spinboard = myDialog.findViewById(R.id.spinboard);
                spinsyllabus = myDialog.findViewById(R.id.spinsyllabus);
                spinsubject = myDialog.findViewById(R.id.spinsubject);
                spinnation = myDialog.findViewById(R.id.spinnation);
                spincountry = myDialog.findViewById(R.id.spincountry);

                ArrayAdapter<String> arrayAdapterboard = new ArrayAdapter<String>(ConfirmTeacher.this, android.R.layout.simple_dropdown_item_1line, Board);
                spinboard.setAdapter(arrayAdapterboard);
                ArrayAdapter<String> arrayAdaptersyllabus = new ArrayAdapter<String>(ConfirmTeacher.this, android.R.layout.simple_dropdown_item_1line, Syllabus);
                spinsyllabus.setAdapter(arrayAdaptersyllabus);
                ArrayAdapter<String> arrayAdaptersubject = new ArrayAdapter<String>(ConfirmTeacher.this, android.R.layout.simple_dropdown_item_1line, Subject);
                spinsubject.setAdapter(arrayAdaptersubject);
                ArrayAdapter<String> arrayAdapternation = new ArrayAdapter<String>(ConfirmTeacher.this, android.R.layout.simple_dropdown_item_1line, Nation);
                spinnation.setAdapter(arrayAdapternation);
                ArrayAdapter<String> arrayAdaptercountry = new ArrayAdapter<String>(ConfirmTeacher.this, android.R.layout.simple_dropdown_item_1line, Country);
                spincountry.setAdapter(arrayAdaptercountry);

                cardsearching.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                        getSupportActionBar().setTitle("Confirm Your\nTeacher");

                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                myDialog.setCanceledOnTouchOutside(true);
                if (!myDialog.isShowing()){
                    getSupportActionBar().setTitle("Confirm Your\nTeacher");

                }
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
                        Intent i1 = new Intent(ConfirmTeacher.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ConfirmTeacher.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ConfirmTeacher.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ConfirmTeacher.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ConfirmTeacher.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ConfirmTeacher.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ConfirmTeacher.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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
                Intent i1 = new Intent(ConfirmTeacher.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ConfirmTeacher .this, Notification.class));
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        final Configuration override = new Configuration(newBase.getResources().getConfiguration());
        override.fontScale = 1.0f;
        applyOverrideConfiguration(override);
    }
}