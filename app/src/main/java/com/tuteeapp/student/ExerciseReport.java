package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.tuteeapp.student.Adapter.ExerciseReportAdapter;
import com.tuteeapp.student.Adapter.PageAdapter;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.ExerciseReportModel;
import com.tuteeapp.student.Model.OptionModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseReport extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomnav;
    ImageView img_back;
    TextView btn_share;

    RecyclerView rv_report;
    PageAdapter pageAdapter;
    RecyclerView rv_page;
    ArrayList<AllModel> arrayList = new ArrayList();
    ArrayList<ExerciseReportModel> exerciseReportModels = new ArrayList();
    PageAdapter.callback indicatorCallback;
    ExerciseReportAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_report);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = findViewById(R.id.drawer_layout);
        navview = findViewById(R.id.nav_view);
        bottomnav = (BottomNavigationView) findViewById(R.id.bottomnav);
        img_back = findViewById(R.id.img_back);
        rv_report = findViewById(R.id.rv_report);
        rv_page = findViewById(R.id.rv_page);
        btn_share = findViewById(R.id.btn_share);


        arrayList.add(new AllModel("1"));
        arrayList.add(new AllModel("2"));
        arrayList.add(new AllModel("3"));
        indicatorCallback = new PageAdapter.callback() {
            @Override
            public void onTitleClicked(int position) {
                pageAdapter.setSelectedIndex(position);
                pageAdapter.notifyDataSetChanged();
            }
        };

        pageAdapter = new PageAdapter(ExerciseReport.this,arrayList,indicatorCallback);
        rv_page.setAdapter(pageAdapter);



        rv_report.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ExerciseReport.this);
        rv_report.setLayoutManager(linearLayoutManager);
        List<OptionModel> model = new ArrayList<>();
        model.add(new OptionModel("C"));
        model.add(new OptionModel(""));
        model.add(new OptionModel(""));
        model.add(new OptionModel(""));
        exerciseReportModels.add(new ExerciseReportModel("Objective",model));
        List<OptionModel> model2 = new ArrayList<>();
        model2.add(new OptionModel("I"));
        model2.add(new OptionModel(""));
        model2.add(new OptionModel(""));
        model2.add(new OptionModel(""));
        exerciseReportModels.add(new ExerciseReportModel("Practice",model2));
        List<OptionModel> model3 = new ArrayList<>();
        model3.add(new OptionModel("C"));
        model3.add(new OptionModel(""));
        model3.add(new OptionModel(""));
        model3.add(new OptionModel(""));
        exerciseReportModels.add(new ExerciseReportModel("Activity",model3));
        List<OptionModel> model4 = new ArrayList<>();
        model4.add(new OptionModel("C"));
        model4.add(new OptionModel(""));
        model4.add(new OptionModel(""));
        model4.add(new OptionModel(""));
        exerciseReportModels.add(new ExerciseReportModel("Solving Problem",model4));

        adapter = new ExerciseReportAdapter(ExerciseReport.this,exerciseReportModels);
        rv_report.setAdapter(adapter);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExerciseReport.this, ScreenShare.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
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
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(ExerciseReport.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ExerciseReport.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ExerciseReport.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ExerciseReport.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ExerciseReport.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ExerciseReport.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ExerciseReport.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom2);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setTitle("Home");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ExerciseReport.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ExerciseReport.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(ExerciseReport.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(ExerciseReport.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ExerciseReport.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

                return true;
            }
        });
        //   bottomnav.setSelectedItemId(R.id.menu_classroom);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    public static class PageAdapter extends RecyclerView.Adapter<PageAdapter.Myholder> {
        Context context;
        ArrayList<AllModel> arrayList;
        private PageAdapter.callback listener;
        private View selectView;
        private int selectedIndex;

        public PageAdapter(Context context, ArrayList<AllModel> arrayList, callback listener) {
            this.context = context;
            this.arrayList = arrayList;
            this.listener = listener;
            selectedIndex = 0;
        }

        @NonNull
        @Override
        public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.selected_page, parent, false);
            Myholder myholder = new Myholder(view);
            return myholder;
        }

        @Override
        public void onBindViewHolder(@NonNull final Myholder holder, final int position) {
            holder.number.setText(arrayList.get(position).getNumber());
            if(selectedIndex == position){
                holder.number.setBackgroundResource(R.drawable.background3);
                holder.number.setTextColor(Color.WHITE);
                selectedIndex = position;
                selectView = holder.number;
            }else {
                holder.number.setBackgroundColor(Color.WHITE);
                holder.number.setTextColor(Color.BLACK);

            }

            holder.number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.number.setBackgroundResource(R.drawable.background3);
                    holder.number.setTextColor(Color.WHITE);
                    if(selectedIndex != position){
                        selectView.setBackgroundColor(Color.WHITE);
                        holder.number.setTextColor(Color.BLACK);
                    }
                    selectView = holder.number;
                    selectedIndex = position;
                    listener.onTitleClicked(position);
                }
            });
        }
        public void setSelectedIndex(int position){
            selectedIndex = position;
        }

        public interface callback{
            void onTitleClicked(int position);
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class Myholder extends RecyclerView.ViewHolder{
            TextView number;


            public Myholder(@NonNull View itemView) {
                super(itemView);
                number = itemView.findViewById(R.id.number);
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
                Intent i1 = new Intent(ExerciseReport.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                Intent i2 = new Intent(ExerciseReport.this, Notification.class);
                startActivity(i2);
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