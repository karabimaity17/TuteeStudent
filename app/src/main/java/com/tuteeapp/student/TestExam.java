package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;

import com.tuteeapp.student.Adapter.QuestionAdapter;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.QuestionModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TestExam extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    BottomNavigationView bottom_navigationView;
    ImageView img_back;

    ArrayList<AllModel> arrayList = new ArrayList();
    ArrayList<QuestionModel> questionModels  = new ArrayList();
    PageAdapter pageAdapter;
    QuestionAdapter questionAdapter;
    RecyclerView rv_page,rv_question;
    TextView submit;
    private static int currentPage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_exam);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        bottom_navigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        img_back = findViewById(R.id.img_back);
        rv_question = findViewById(R.id.rv_question);
        rv_page = findViewById(R.id.rv_page);
        submit = findViewById(R.id.submit);

        arrayList.add(new AllModel("1"));
        arrayList.add(new AllModel("2"));
        arrayList.add(new AllModel("3"));
        arrayList.add(new AllModel("4"));
        arrayList.add(new AllModel("5"));
        pageAdapter = new PageAdapter(TestExam.this,arrayList);
        rv_page.setAdapter(pageAdapter);

        questionModels.add(new QuestionModel("1"));
        questionModels.add(new QuestionModel("2"));
        questionModels.add(new QuestionModel("3"));
        questionModels.add(new QuestionModel("4"));
        questionModels.add(new QuestionModel("5"));
        questionAdapter = new QuestionAdapter(questionModels,TestExam.this);
        rv_question.setAdapter(questionAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage = currentPage+1;

                if (currentPage < arrayList.size()) {
                    pageAdapter.setSelectedIndex(currentPage);
                    pageAdapter.notifyDataSetChanged();
                    rv_page.scrollToPosition(currentPage);
                    questionAdapter.setSelectedIndex(currentPage);
                    questionAdapter.notifyDataSetChanged();
                    rv_question.scrollToPosition(currentPage);
                }else if(currentPage == arrayList.size()){
                    startActivity(new Intent(TestExam.this,ExamSubmit.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });

        RecyclerView.OnItemTouchListener disabler = new RecyclerViewDisabler();

        rv_question.addOnItemTouchListener(disabler);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        drawerToggle.setDrawerIndicatorEnabled(false);
        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        drawerToggle.setHomeAsUpIndicator(R.drawable.toggle);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        Intent i1 = new Intent(TestExam.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(TestExam.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(TestExam.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(TestExam.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(TestExam.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(TestExam.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(TestExam.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottom_navigationView.getMenu().getItem(2).setIcon(R.drawable.teacher2);
        bottom_navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setTitle("Home");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    bottom_navigationView.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(TestExam.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottom_navigationView.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(TestExam.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    startActivity(new Intent(TestExam.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));

                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(TestExam.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottom_navigationView.getMenu().getItem(2).setIcon(R.drawable.teacher);

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottom_navigationView.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(TestExam.this,MyProfile.class));
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

    public class RecyclerViewDisabler implements RecyclerView.OnItemTouchListener {

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            return true;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
    public class PageAdapter extends RecyclerView.Adapter<PageAdapter.Myholder> {
        Context context;
        ArrayList<AllModel> arrayList;
        private int selectedIndex = 0;

        public PageAdapter(Context context, ArrayList<AllModel> arrayList) {
            this.context = context;
            this.arrayList = arrayList;

        }

        @NonNull
        @Override
        public PageAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
                currentPage = position;
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
                        holder.number.setBackgroundColor(Color.WHITE);
                        holder.number.setTextColor(Color.BLACK);
                    }
                    selectedIndex = position;
                    currentPage = position;

                    pageAdapter.setSelectedIndex(position);
                    pageAdapter.notifyDataSetChanged();
                    rv_page.scrollToPosition(position);
                    questionAdapter.setSelectedIndex(position);
                    questionAdapter.notifyDataSetChanged();
                    rv_question.scrollToPosition(position);
                }
            });
        }
        public void setSelectedIndex(int position){
            selectedIndex = position;
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
                Intent i1 = new Intent(TestExam.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(TestExam.this, Notification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
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