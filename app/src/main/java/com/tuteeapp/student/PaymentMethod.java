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

public class PaymentMethod extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    public ImageView img_back;

    RadioButton btneme, btnvisa, btnbank, btnpaypal;
    Button btncontinue;
    String method="eme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle("Payment\nMethod");

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        img_back = findViewById(R.id.img_back);

        btneme = findViewById(R.id.btneme);
        btnvisa = findViewById(R.id.btnvisa);
        btnbank = findViewById(R.id.btnbank);
        btnpaypal = findViewById(R.id.btnpaypal);
        btncontinue = findViewById(R.id.btncontinue);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (method.equals("eme")) {
                    Intent i = new Intent(PaymentMethod.this, EmePay.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else if (method.equals("visa")) {
                    Intent i = new Intent(PaymentMethod.this, CreditDebitCard.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else if (method.equals("bank")) {

                }else {

                }

            }
        });

        btneme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbank.setChecked(false);
                btnpaypal.setChecked(false);
                btnvisa.setChecked(false);
                method="eme";
                btncontinue.setText("Continue with Emepay");
                startActivity(new Intent(PaymentMethod.this, EmePay.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        btnvisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnbank.setChecked(false);
                btnpaypal.setChecked(false);
                btneme.setChecked(false);
                method="visa";
                btncontinue.setText("Continue with Credit/Debit Card");
                startActivity(new Intent(PaymentMethod.this, CreditDebitCard.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        btnbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnvisa.setChecked(false);
                btnpaypal.setChecked(false);
                btneme.setChecked(false);
                method="bank";
                btncontinue.setText("Continue");

            }
        });


        btnpaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnvisa.setChecked(false);
                btnbank.setChecked(false);
                btneme.setChecked(false);
                method="paypal";
                btncontinue.setText("Continue");
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
                        Intent i1 = new Intent(PaymentMethod.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(PaymentMethod.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(PaymentMethod.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(PaymentMethod.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(PaymentMethod.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(PaymentMethod.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(PaymentMethod.this, Settings.class));
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
                Intent i1 = new Intent(PaymentMethod.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(PaymentMethod .this, Notification.class));
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