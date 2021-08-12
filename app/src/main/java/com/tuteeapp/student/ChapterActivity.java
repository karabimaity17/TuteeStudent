package com.tuteeapp.student;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Adapter.ChapterAdapter;
import com.tuteeapp.student.Model.ChapterModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ChapterActivity extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    public ImageView img_back;
    BottomNavigationView bottomnav;

    LinearLayout lin_comment;
    ArrayList<ChapterModel> arrayList = new ArrayList();
    RecyclerView rv1;
    TextView ebook, textmore;
    Dialog myDialog;
    CardView card_exercise,card_test_exam,card_assignment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.nav_view);
        img_back = findViewById(R.id.img_back);
        bottomnav = findViewById(R.id.bottomnav);

        myDialog = new Dialog(ChapterActivity.this);
        rv1 =findViewById(R.id.rv1);
        ebook = findViewById(R.id.ebook);
        textmore = findViewById(R.id.textmore);
        card_assignment = findViewById(R.id.card_assignment);
        card_test_exam = findViewById(R.id.card_test_exam);
        card_exercise = findViewById(R.id.card_exercise);
        lin_comment = findViewById(R.id.lin_comment);

        rv1.setAdapter(new ChapterAdapter(arrayList,ChapterActivity.this));
        arrayList.add(new ChapterModel(R.drawable.image1, "1"));
        arrayList.add(new ChapterModel(R.drawable.image2, "2"));
        arrayList.add(new ChapterModel(R.drawable.image3, "3"));
        arrayList.add(new ChapterModel(R.drawable.image4, "4"));
        arrayList.add(new ChapterModel(R.drawable.image5, "5"));
        arrayList.add(new ChapterModel(R.drawable.image6, "6"));

        textmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ChapterActivity.this, R.style.BottomSheetDialogTransparent);
                View bottomSheetView = LayoutInflater.from(ChapterActivity.this).inflate(R.layout.dialog_chapter_more, null);
                final CardView cardinfo = bottomSheetView.findViewById(R.id.info);
                final CardView cardsave = bottomSheetView.findViewById(R.id.cardsend);
                final CardView cardexercise = bottomSheetView.findViewById(R.id.exercise);
                final CardView cardanalysis = bottomSheetView.findViewById(R.id.analysis);
                final CardView cardtest = bottomSheetView.findViewById(R.id.test);
                CardView cancel = bottomSheetView.findViewById(R.id.btncancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });

        ebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterActivity.this,ChapterEbook.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        card_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterActivity.this,ExerciseActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        card_assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterActivity.this,AssignmentLibrary.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        card_test_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChapterActivity.this,TestExamLibrary.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        lin_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChapterActivity.this, Comments.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
                        Intent i1 = new Intent(ChapterActivity.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ChapterActivity.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ChapterActivity.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ChapterActivity.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ChapterActivity.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ChapterActivity.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ChapterActivity.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottomnav.getMenu().getItem(0).setIcon(R.drawable.home2);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    startActivity(new Intent(ChapterActivity.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    menuItem.setTitle("Home");

                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    startActivity(new Intent(ChapterActivity.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));
                    startActivity(new Intent(ChapterActivity.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                }else if(id== R.id.menu_classroom){

                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    startActivity(new Intent(ChapterActivity.this,Classroom.class));
                    menuItem.setTitle("Classroom");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.classroom2));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(0).setIcon(R.drawable.home);
                    startActivity(new Intent(ChapterActivity.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

                return true;
            }
        });
       // bottomnav.setSelectedItemId(R.id.menu_home);
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
                Intent i1 = new Intent(ChapterActivity.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ChapterActivity .this, Notification.class));
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
