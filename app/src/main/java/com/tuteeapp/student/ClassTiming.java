package com.tuteeapp.student;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tuteeapp.student.Adapter.ChooseSubAdapter;
import com.tuteeapp.student.Model.Model_Choosesub;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassTiming extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomnav;
    ImageView img_back;

    RecyclerView rvsubject;
    ArrayList<Model_Choosesub> alist = new ArrayList<>();
    TextView alarm;
    String selected="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_timing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = findViewById(R.id.drawer_layout);
        navview = findViewById(R.id.nav_view);
        bottomnav = (BottomNavigationView) findViewById(R.id.bottomnav);
        img_back = findViewById(R.id.img_back);
        alarm = findViewById(R.id.alarm);

        rvsubject = findViewById(R.id.rvsubject);

        alist.add(new Model_Choosesub("English"));
        alist.add(new Model_Choosesub("Mathematics"));
        alist.add(new Model_Choosesub("Physics"));

        rvsubject.setAdapter(new ChooseSubAdapter(alist));

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selected.equals("")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("page_name", selected);
                    startActivity(new Intent(ClassTiming.this, SubjectTiming.class).putExtras(bundle));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }else {
                    Toast.makeText(ClassTiming.this, "Select Subject", Toast.LENGTH_SHORT).show();
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
        navview.setItemIconTintList(null);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(ClassTiming.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ClassTiming.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ClassTiming.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ClassTiming.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ClassTiming.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ClassTiming.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ClassTiming.this, Settings.class));
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
                    startActivity(new Intent(ClassTiming.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ClassTiming.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(ClassTiming.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(ClassTiming.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(3).setIcon(R.drawable.classroom);
                    startActivity(new Intent(ClassTiming.this,MyProfile.class));
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
    public class ChooseSubAdapter extends RecyclerView.Adapter<ChooseSubAdapter.Myholder> {
        ArrayList<Model_Choosesub> arrayList;
        int row_index = -1;

        public ChooseSubAdapter(ArrayList<Model_Choosesub> arrayList) {
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.single_choosesub, parent, false);
            Myholder myholder = new Myholder(view);
            return myholder;
        }

        @Override
        public void onBindViewHolder(@NonNull final Myholder holder, final int position) {
            holder.checkbox.setText(arrayList.get(position).getTextsubject());


            if (row_index == -1) {
                holder.checkbox.setChecked(false);


            } else {
                if (row_index == position) {
                    holder.checkbox.setChecked(true);



                } else {
                    holder.checkbox.setChecked(false);

                }
            }

            holder.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.checkbox.setChecked(true);

                    selected=holder.checkbox.getText().toString();
                   // Toast.makeText(ClassTiming.this, ""+selected, Toast.LENGTH_SHORT).show();
                    if (row_index != position) {
                        notifyItemChanged(row_index);
                        row_index = position;
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class Myholder extends RecyclerView.ViewHolder {
            TextView textsub;
            RadioButton btnradio;
            CheckBox checkbox;

            public Myholder(@NonNull View itemView) {
                super(itemView);
                textsub = itemView.findViewById(R.id.textsub);
                btnradio = itemView.findViewById(R.id.btnradio);
                checkbox = itemView.findViewById(R.id.checkbox);
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
                Intent i1 = new Intent(ClassTiming.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ClassTiming .this, Notification.class));
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