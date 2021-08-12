package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import com.tuteeapp.student.Adapter.Notification_Adapter;
import com.tuteeapp.student.Model.Model_Notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Notification extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    ImageView img_back;

    LinearLayout bottomsheet_notification;
    BottomSheetBehavior sheetBehavior;

    RecyclerView rv_notification,rv_notification2;
    List<Model_Notification> model_notifications=new ArrayList<>();
    List<Model_Notification> model_notifications2=new ArrayList<>();
    Notification_Adapter notification_adapter;
    Notification_Adapter2 notification_adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        img_back = findViewById(R.id.img_back);
        bottomsheet_notification = findViewById(R.id.bottomsheet_notification);
        sheetBehavior = BottomSheetBehavior.from(bottomsheet_notification);



        sheetBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
        model_notifications = new ArrayList<>();

        rv_notification = findViewById(R.id.rv_notification);
        rv_notification.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Notification.this,LinearLayoutManager.VERTICAL,false);
        rv_notification.setLayoutManager(linearLayoutManager);
        model_notifications.add(new Model_Notification(R.drawable.img_man,"Daniel William","CBSE | UAE","New English Lesson available"));
        model_notifications.add(new Model_Notification(R.drawable.img_man,"Daniel William","CBSE | UAE","New English Lesson available"));
        model_notifications.add(new Model_Notification(R.drawable.img_man,"Daniel William","CBSE | UAE","New English Lesson available"));
        notification_adapter = new Notification_Adapter(this,model_notifications);
        rv_notification.setAdapter(notification_adapter);

        rv_notification2 = findViewById(R.id.rv_notification2);
        rv_notification2.setHasFixedSize(true);

        rv_notification2.setLayoutManager(new LinearLayoutManager(Notification.this,LinearLayoutManager.VERTICAL,false));
        model_notifications2.add(new Model_Notification("Admin","","15% off your EdumeApp renewal to help your learning"));
        model_notifications2.add(new Model_Notification("Admin","","15% off your EdumeApp renewal to help your learning"));
        model_notifications2.add(new Model_Notification("Admin","","15% off your EdumeApp renewal to help your learning"));
        notification_adapter2 = new Notification_Adapter2(this,model_notifications2);
        rv_notification2.setAdapter(notification_adapter2);


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
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(Notification.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(Notification.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(Notification.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(Notification.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(Notification.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(Notification.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(Notification.this, Settings.class));
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
    public class Notification_Adapter2 extends RecyclerView.Adapter<Notification_Adapter2.MyViewHolder> {

        Context context;
        List<Model_Notification> model = new ArrayList<>();

        public Notification_Adapter2(Context context, List<Model_Notification> model) {
            this.context = context;
            this.model = model;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_admin_notification, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.text_name.setText(model.get(position).getText_name());
            holder.board.setText(model.get(position).getBoard());
            holder.desc.setText(model.get(position).getDesc());
           // holder.image.setImageResource(model.get(position).getImage());

        }

        @Override
        public int getItemCount() {
            return model.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text_name,board,desc;
            ImageView image;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                text_name = itemView.findViewById(R.id.text_name);
                board = itemView.findViewById(R.id.board);
                desc = itemView.findViewById(R.id.desc);
                image = itemView.findViewById(R.id.image);

            }
        }
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
                Intent i1 = new Intent(Notification.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(Notification.this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
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