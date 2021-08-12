package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.tuteeapp.student.Model.ResponseMessageModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScreenShareChat extends AppCompatActivity {
    NavigationView navview;
    DrawerLayout drawer;
    ActionBarDrawerToggle drawerToggle;
    BottomNavigationView bottomnav;
    ImageView img_back;

    RecyclerView rv_chat;
    List<ResponseMessageModel> allChatModels= new ArrayList<>();
    MessageAdapter chatAdapter;

    EditText edit_msg;
    ImageView img_micro,img_camera,img_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_share_chat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawer = findViewById(R.id.drawer);
        navview = findViewById(R.id.navview);
        bottomnav = (BottomNavigationView) findViewById(R.id.bottomnav);
        img_back = findViewById(R.id.img_back);

        rv_chat=findViewById(R.id.rv_chat);
        edit_msg = findViewById(R.id.edit_msg);
        img_micro = findViewById(R.id.img_micro);
        img_camera = findViewById(R.id.img_camera);
        img_send = findViewById(R.id.img_send);

        allChatModels.add(new ResponseMessageModel(
                "",
                "",
                "",
                ""));

        allChatModels.add(new ResponseMessageModel(
                "",
                "send",
                "",
                ""));

        allChatModels.add(new ResponseMessageModel(
                "",
                "",
                "",
                ""));

        allChatModels.add(new ResponseMessageModel(
                "",
                "send",
                "",
                ""));


        chatAdapter= new MessageAdapter(ScreenShareChat.this,allChatModels);
        rv_chat.setHasFixedSize(true);
        rv_chat.setLayoutManager(new LinearLayoutManager(ScreenShareChat.this));
        rv_chat.setAdapter(chatAdapter);


        edit_msg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count==0){
                    img_micro.setVisibility(View.VISIBLE);
                    img_camera.setVisibility(View.VISIBLE);
                    img_send.setVisibility(View.GONE);
                }else{
                    img_micro.setVisibility(View.GONE);
                    img_camera.setVisibility(View.GONE);
                    img_send.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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
                        Intent i1 = new Intent(ScreenShareChat.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(ScreenShareChat.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(ScreenShareChat.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(ScreenShareChat.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(ScreenShareChat.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(ScreenShareChat.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(ScreenShareChat.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher2);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id=menuItem.getItemId();

                if(id== R.id.menu_home2){
                    menuItem.setTitle("Home");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.home2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(ScreenShareChat.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(ScreenShareChat.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    startActivity(new Intent(ScreenShareChat.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));

                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(ScreenShareChat.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(ScreenShareChat.this,MyProfile.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }

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
    public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

        Context context;
        int Self;
        int Other;
        View v;


        List<ResponseMessageModel> responseMessages;

        public MessageAdapter(Context context, List<ResponseMessageModel> responseMessages) {
            this.context = context;
            this.responseMessages = responseMessages;
        }

        @Override
        public int getItemViewType(int position) {
            if (responseMessages.get(position).getMy_id().equals("send")){
                return R.layout.messege_send;
            }
            return R.layout.messege_receive;
        }

        @NonNull
        @Override
        public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            v= LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);

            return new MessageAdapter.ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MessageAdapter.ViewHolder holder, int position) {
//            holder.txtMessage.setText(responseMessages.get(position).getMessage());
//            holder.textViewDate.setText(responseMessages.get(position).getDate());
//            holder.textViewTime.setText(responseMessages.get(position).getTime());
        }

        @Override
        public int getItemCount() {
            return responseMessages.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtMessage,textViewTime,textViewDate;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

//                txtMessage=itemView.findViewById(R.id.txtMessage);
//                textViewDate=itemView.findViewById(R.id.textViewDate);
//                textViewTime=itemView.findViewById(R.id.textViewTime);
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
                Intent i1 = new Intent(ScreenShareChat.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(ScreenShareChat.this, Notification.class));
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