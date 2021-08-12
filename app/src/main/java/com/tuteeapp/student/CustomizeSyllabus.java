package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomizeSyllabus extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;

    public ImageView img_back;
    Button btnnext;
    LinearLayout linear2, linear3;
    LinearLayout linear1;
    CardView carduk, cardusa, cardindia, cardaus, cardcbsc, cardssc, cardicse, cardib, cardteacher;
    TextView textteacher, textnumber;
    String page="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_syllabus);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Customize\nYour Syllabus");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);

        img_back = findViewById(R.id.img_back);

        btnnext = findViewById(R.id.btnnext);
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        carduk = findViewById(R.id.carduk);
        cardusa = findViewById(R.id.cardusa);
        cardindia = findViewById(R.id.cardindia);
        cardaus = findViewById(R.id.cardaus);
        cardcbsc = findViewById(R.id.cardcbse);
        cardssc = findViewById(R.id.cardssc);
        cardicse = findViewById(R.id.cardicse);
        cardib = findViewById(R.id.cardib);
        cardteacher = findViewById(R.id.cardteacher);
        textnumber = findViewById(R.id.textnumber);
        textteacher = findViewById(R.id.textteacher);

        linear2.setVisibility(View.GONE);
        linear3.setVisibility(View.GONE);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CustomizeSyllabus.this, ChooseSubject.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        cardteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  btnnext.setEnabled(true);
                //  cardteacher.setBackgroundResource(R.drawable.background);
                //   textnumber.setTextColor(getApplication().getResources().getColor(R.color.white));
                //  textteacher.setTextColor(getApplication().getResources().getColor(R.color.white));
            }
        });
        carduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="2";
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
        cardusa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="2";
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
        cardindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="2";
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
        cardaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="2";
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.GONE);
                linear2.setVisibility(View.VISIBLE);
            }
        });
        cardcbsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="3";
                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
            }
        });
        cardicse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="3";
                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
            }
        });
        cardssc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="3";
                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
            }
        });
        cardib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page="3";
                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.GONE);
                linear3.setVisibility(View.VISIBLE);
            }
        });
        // for back button //
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (page.equals("3")){
                    page="2";
                    linear1.setVisibility(View.GONE);
                    linear3.setVisibility(View.GONE);
                    linear2.setVisibility(View.VISIBLE);
                }else if (page.equals("2")){
                    page="1";
                    linear2.setVisibility(View.GONE);
                    linear3.setVisibility(View.GONE);
                    linear1.setVisibility(View.VISIBLE);
                }else{
                    if (drawer.isDrawerOpen(GravityCompat.START)) {
                        drawer.closeDrawer(GravityCompat.START);
                    } else {
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
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
                        Intent i1 = new Intent(CustomizeSyllabus.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(CustomizeSyllabus.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(CustomizeSyllabus.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(CustomizeSyllabus.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(CustomizeSyllabus.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(CustomizeSyllabus.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(CustomizeSyllabus.this, Settings.class));
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
                Intent i1 = new Intent(CustomizeSyllabus.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(CustomizeSyllabus .this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        if (page.equals("3")){
            page="2";
            linear1.setVisibility(View.GONE);
            linear3.setVisibility(View.GONE);
            linear2.setVisibility(View.VISIBLE);
        }else if (page.equals("2")){
            page="1";
            linear2.setVisibility(View.GONE);
            linear3.setVisibility(View.GONE);
            linear1.setVisibility(View.VISIBLE);
        }else{
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
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