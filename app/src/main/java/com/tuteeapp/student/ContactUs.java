package com.tuteeapp.student;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    public ImageView img_back;

    RadioGroup rg_customer,rg_academic,rg_teacher;
    RadioButton btncustomer,btnacademic,btnteacher;
    String type="",topic="";
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Contact Us");

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        img_back = findViewById(R.id.img_back);

        btnsend = findViewById(R.id.btnsend);

        rg_customer = findViewById(R.id.rg_customer);
        rg_academic = findViewById(R.id.rg_academic);
        rg_teacher = findViewById(R.id.rg_teacher);
        btnteacher = findViewById(R.id.btnteacher);
        btnacademic = findViewById(R.id.btnacademic);
        btncustomer = findViewById(R.id.btncustomer);

        btncustomer.setChecked(true);
        btnacademic.setChecked(false);
        btnteacher.setChecked(false);
        btncustomer.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.purple));
        btnteacher.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));
        btnacademic.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));

        rg_customer.setVisibility(View.VISIBLE);
        rg_academic.setVisibility(View.GONE);
        rg_teacher.setVisibility(View.GONE);
        btncustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnacademic.setChecked(false);
                btnteacher.setChecked(false);
                btncustomer.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.purple));
                btnteacher.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));
                btnacademic.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));

                rg_customer.setVisibility(View.VISIBLE);
                rg_academic.setVisibility(View.GONE);
                rg_teacher.setVisibility(View.GONE);
            }
        });
        btnacademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncustomer.setChecked(false);
                btnteacher.setChecked(false);
                btncustomer.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));
                btnteacher.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));
                btnacademic.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.purple));
                rg_customer.setVisibility(View.GONE);
                rg_academic.setVisibility(View.VISIBLE);
                rg_teacher.setVisibility(View.GONE);
            }
        });
        btnteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnacademic.setChecked(false);
                btncustomer.setChecked(false);
                btncustomer.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));
                btnteacher.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.purple));
                btnacademic.setTextColor(ContextCompat.getColor(ContactUs.this,R.color.light_black));
                rg_customer.setVisibility(View.GONE);
                rg_academic.setVisibility(View.GONE);
                rg_teacher.setVisibility(View.VISIBLE);
            }
        });


        rg_academic.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    topic=rb.getText().toString();
                    rg_customer.clearCheck();
                    rg_teacher.clearCheck();

                }
            }
        });

        rg_customer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    topic=rb.getText().toString();
                    rg_academic.clearCheck();
                    rg_teacher.clearCheck();

                }
            }
        });

        rg_teacher.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    topic=rb.getText().toString();
                    rg_customer.clearCheck();
                    rg_academic.clearCheck();
                }
            }
        });

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
                //Toast.makeText(ContactUs.this, ""+topic, Toast.LENGTH_SHORT).show();
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

        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(ContactUs.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ContactUs.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ContactUs.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ContactUs.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ContactUs.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ContactUs.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ContactUs.this, Settings.class));
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
                Intent i1 = new Intent(ContactUs.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ContactUs .this, Notification.class));
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