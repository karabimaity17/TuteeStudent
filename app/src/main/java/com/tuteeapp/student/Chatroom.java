package com.tuteeapp.student;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.tuteeapp.student.Adapter.ChatAdapter;
import com.tuteeapp.student.Model.AllChatModel;
import com.tuteeapp.student.Model.ResponseMessageModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Chatroom extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    BottomNavigationView bottomnav;
    ImageView img_back;

    RecyclerView rv_chat;
    List<ResponseMessageModel> allChatModels= new ArrayList<>();
    MessageAdapter chatAdapter;
    ArrayList<String> arrayList=new ArrayList<>();

    EditText edit_msg;
    ImageView img_micro,img_camera,img_send,attach,close;
    TextView txt_name,txt_msg;
    LinearLayout lin_option;
    CardView card_copy,card_forward,card_delete;
    int counter=0;
    View view2,view_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navview);
        bottomnav = (BottomNavigationView) findViewById(R.id.bottomnav);
        img_back = findViewById(R.id.img_back);

        rv_chat=findViewById(R.id.rv_chat);
        edit_msg = findViewById(R.id.edit_msg);
        img_micro = findViewById(R.id.img_micro);
        img_camera = findViewById(R.id.img_camera);
        img_send = findViewById(R.id.img_send);
        card_delete = findViewById(R.id.card_delete);
        card_forward = findViewById(R.id.card_forward);
        card_copy = findViewById(R.id.card_copy);
        lin_option = findViewById(R.id.lin_option);
        attach = findViewById(R.id.attach);
        view2 = findViewById(R.id.view);
        view_color = findViewById(R.id.view_color);
        close = findViewById(R.id.close);
        txt_msg = findViewById(R.id.txt_msg);
        txt_name = findViewById(R.id.txt_name);

        allChatModels.add(new ResponseMessageModel(
               "",
                "",
                "",
                "",
                "chat",
                false));

        allChatModels.add(new ResponseMessageModel(
               "",
                "send",
                "",
                "",
                "chat",
                false));

        allChatModels.add(new ResponseMessageModel(
               "",
                "",
                "",
                "",
                "chat",
                false));

        allChatModels.add(new ResponseMessageModel(
               "",
                "send",
                "",
                "",
                "chat",
                false));

        allChatModels.add(new ResponseMessageModel(
               "",
                "send",
                "",
                "",
                "audio",
                false));


        chatAdapter= new MessageAdapter(Chatroom.this,allChatModels);
        rv_chat.setHasFixedSize(true);
        rv_chat.setLayoutManager(new LinearLayoutManager(Chatroom.this));
        rv_chat.setAdapter(chatAdapter);

        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Chatroom.this, R.style.BottomSheetDialogTransparent);
                View bottomSheetView = LayoutInflater.from(Chatroom.this).inflate(R.layout.dialog_attach, null);
                final LinearLayout lin_share = bottomSheetView.findViewById(R.id.lin_share);

                CardView cancel = bottomSheetView.findViewById(R.id.btncancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                lin_share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Chatroom.this, ChatInvitation.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
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
                        Intent i1 = new Intent(Chatroom.this, EduMe.class);
                        startActivity(i1);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_profile:
                        Intent i2 = new Intent(Chatroom.this, EditProfile.class);
                        startActivity(i2);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_desktop:
                        Intent i3 = new Intent(Chatroom.this, ConnectDesktop.class);
                        startActivity(i3);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_feedback:
                        Intent i4 = new Intent(Chatroom.this, FeedbackActivity.class);
                        startActivity(i4);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_account:
                        Intent i5 = new Intent(Chatroom.this, MyAccount.class);
                        startActivity(i5);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_contact:
                        Intent i6 = new Intent(Chatroom.this, ContactUs.class);
                        startActivity(i6);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                    case R.id.menu_settings:
                        startActivity(new Intent(Chatroom.this, Settings.class));
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
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
                    startActivity(new Intent(Chatroom.this,EduMe.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_analytic){
                    menuItem.setTitle("Analytics");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.analytics2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(Chatroom.this,Analytics.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }else if(id== R.id.menu_teacher){
                    //ProfileFragment fragmentprof=new ProfileFragment();
                    menuItem.setTitle("Teacher");
                    startActivity(new Intent(Chatroom.this,MyTeacher.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    menuItem.setIcon(getResources().getDrawable(R.drawable.teacher2));

                }else if(id== R.id.menu_classroom){
                    menuItem.setTitle("Classroom");
                    startActivity(new Intent(Chatroom.this,Classroom.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);

                }else if(id== R.id.menu_profile2){
                    menuItem.setTitle("Profile");
                    menuItem.setIcon(getResources().getDrawable(R.drawable.profile2));
                    bottomnav.getMenu().getItem(2).setIcon(R.drawable.teacher);
                    startActivity(new Intent(Chatroom.this,MyProfile.class));
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

        boolean isSelectAll=false;
        boolean isEnable=false;

        List<ResponseMessageModel>  responseMessages;


        public MessageAdapter(Context context, List<ResponseMessageModel> responseMessages) {
            this.context = context;
            this.responseMessages = responseMessages;
        }

        @Override
        public int getItemViewType(int position) {
            if (responseMessages.get(position).getMy_id().equals("send") && responseMessages.get(position).getMsg_type().equals("chat")){
                return R.layout.messege_send;
            }else if (responseMessages.get(position).getMy_id().equals("") && responseMessages.get(position).getMsg_type().equals("chat")){
                return R.layout.messege_receive;
            }else  if (responseMessages.get(position).getMy_id().equals("send") && responseMessages.get(position).getMsg_type().equals("audio")){
                return R.layout.messege_audio_send;
            }
            return R.layout.messege_audio_receive;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            v= LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//            holder.txtMessage.setText(responseMessages.get(position).getMessage());
//            holder.textViewDate.setText(responseMessages.get(position).getDate());
//            holder.textViewTime.setText(responseMessages.get(position).getTime());

//            if (responseMessages.get(position).isShowCheckbox()==true){
//                holder.radio.setVisibility(View.VISIBLE);
//                if (holder.radio.isChecked()){
//                    holder.linear_msg.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            holder.radio.setChecked(false);
//                        }
//                    });
//                    holder.radio.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            holder.radio.setChecked(false);
//                        }
//                    });
//                }else {
//                    holder.radio.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            holder.radio.setChecked(true);
//                        }
//                    });
//                    holder.linear_msg.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            holder.radio.setChecked(true);
//                        }
//                    });
//
//                }
//            }else {
//                holder.linear_msg.setOnLongClickListener(new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        showAllBoxes();
//                        holder.radio.setChecked(true);
//                        return true;
//                    }
//                });
//                holder.radio.setVisibility(View.GONE);
//            }

            if (!isEnable){
                holder.radio.setVisibility(View.GONE);
            }else {
                holder.radio.setVisibility(View.VISIBLE);
                holder.radio.setChecked(false);
            }
            holder.linear_msg.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    isEnable=true;
                    lin_option.setVisibility(View.VISIBLE);
                    //showAllBoxes();
                    chatAdapter.notifyDataSetChanged();
                    return true;
                }
            });
            final Drawable[] drawables = holder.radio.getCompoundDrawables();
            holder.radio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        holder.radio.setBackgroundResource(R.drawable.check_circle);
                        arrayList.add(String.valueOf(allChatModels.get(position)));
                        counter++;
                        Toast.makeText(context, ""+counter, Toast.LENGTH_SHORT).show();
                    }else {
                        holder.radio.setBackgroundResource(R.drawable.checkbox_circle);
                        arrayList.remove(String.valueOf(allChatModels.get(position)));
                        counter--;
                        Toast.makeText(context, ""+counter, Toast.LENGTH_SHORT).show();
                    }
                }
            });
            if (holder.radio.isChecked()){
                holder.radio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MakeSelection( v, position);
                    }
                });

            }else
            {
                holder.radio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MakeSelection( v, position);
                    }
                });

            }




        }

        private void ClickItem(ViewHolder holder) {
            String s= String.valueOf(responseMessages.get(holder.getAdapterPosition()));

            if (holder.radio.getVisibility()==View.GONE){
                holder.radio.setChecked(true);
                arrayList.add(s);
                showAllBoxes();
            }else {
                holder.radio.setChecked(false);
                arrayList.remove(s);
            }

        }

        private void showAllBoxes() {
            for (ResponseMessageModel item : responseMessages) {
                item.setShowCheckbox(true);
            }
            if (!rv_chat.isComputingLayout())
            {
                notifyDataSetChanged();
            }

        }

        private void hideAllBoxes() {
            for (ResponseMessageModel item : responseMessages) {
                item.setShowCheckbox(false);
            }
            if (!rv_chat.isComputingLayout())
            {
                notifyDataSetChanged();
            }
        }
        @Override
        public int getItemCount() {
            return responseMessages.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView txtMessage,textViewTime,textViewDate;
            LinearLayout linear_msg,linear;
            RadioButton radio;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                linear_msg=itemView.findViewById(R.id.linear_msg);
                radio=itemView.findViewById(R.id.radio);
                linear=itemView.findViewById(R.id.linear);
                linear.setOnClickListener(this);
//                textViewDate=itemView.findViewById(R.id.textViewDate);
//                textViewTime=itemView.findViewById(R.id.textViewTime);
            }

            private void showPopupMenu(final View view, boolean isWithIcons) {

                PopupMenu popup = new PopupMenu(view.getContext(), view, Gravity.RIGHT);
                //inflate menu
                popup.getMenuInflater().inflate(R.menu.chat_menu1, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.option_star:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_reply:
                                view2.setVisibility(View.VISIBLE);
                                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                                        R.anim.slide_in_bottom);
                                view2.startAnimation(animFadeIn);
                                view_color.setBackgroundColor(ContextCompat.getColor(context,R.color.light_blue));
                                txt_name.setTextColor(ContextCompat.getColor(context,R.color.light_blue));
                                txt_name.setText("Daniel William");
                                if (responseMessages.get(getAdapterPosition()).getMsg_type().equals("audio")){

                                    txt_msg.setText("Audio");
                                    txt_msg.setCompoundDrawablesWithIntrinsicBounds(R.drawable.grey_micro, 0, 0, 0);
                                }else{
                                    txt_msg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                                    txt_msg.setText("Hey Martin! How are you?");


                                }
                                close.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                                                R.anim.slide_out_bottom);
                                        view2.startAnimation(animFadeIn);
                                        view2.setVisibility(View.GONE);
                                    }
                                });
                                return true;
                            case R.id.option_frwd:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_copy:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_delete:
                                showPopupMenu2(view);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }

            private void showPopupMenuSend(final View view, boolean isWithIcons) {

                PopupMenu popup = new PopupMenu(view.getContext(), view, Gravity.RIGHT);
                //inflate menu
                popup.getMenuInflater().inflate(R.menu.chat_menu_send1, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.option_star:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_info:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_reply:
                                view2.setVisibility(View.VISIBLE);
                                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                                        R.anim.slide_in_bottom);
                                view2.startAnimation(animFadeIn);
                                view_color.setBackgroundColor(ContextCompat.getColor(context,R.color.teal_200));
                                txt_name.setTextColor(ContextCompat.getColor(context,R.color.teal_200));
                                txt_name.setText("You");
                                if (responseMessages.get(getAdapterPosition()).getMsg_type().equals("audio")){
                                    txt_msg.setText("Audio");
                                    txt_msg.setCompoundDrawablesWithIntrinsicBounds(R.drawable.grey_micro, 0, 0, 0);
                                }else{
                                    txt_msg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                                    txt_msg.setText("Hey Martin! How are you?");
                                }
                                close.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                                                R.anim.slide_out_bottom);
                                        view2.startAnimation(animFadeIn);
                                        view2.setVisibility(View.GONE);
                                    }
                                });
                                return true;
                            case R.id.option_frwd:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_copy:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_delete:
                                showPopupMenu2(view);
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }

            private void showPopupMenu2(View item) {
                PopupMenu popupMenu = new PopupMenu(item.getContext(), item);
                popupMenu.inflate(R.menu.chat_menu2);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.option_everyone:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_me:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.option_cancel:
                                Toast.makeText(context, ""+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }

            @Override
            public void onClick(View v) {
                if (responseMessages.get(getAdapterPosition()).getMy_id().equals("send")){
                    showPopupMenuSend(v,true);
                }else{
                    showPopupMenu(v,true);
                }

            }


        }


    }

    private void MakeSelection(View v, int position) {

        if (((RadioButton)v).isChecked()){
            ((RadioButton)v).setBackgroundResource(R.drawable.checkbox_circle);
            arrayList.remove(String.valueOf(allChatModels.get(position)));
            counter--;
            Toast.makeText(Chatroom.this, ""+counter, Toast.LENGTH_SHORT).show();
        }else {
            ((RadioButton)v).setBackgroundResource(R.drawable.check_circle);
            arrayList.add(String.valueOf(allChatModels.get(position)));
            counter++;
            Toast.makeText(Chatroom.this, ""+counter, Toast.LENGTH_SHORT).show();
        }
    }

    private void Update() {
        Toast.makeText(this, counter+" Items", Toast.LENGTH_SHORT).show();
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
                Intent i1 = new Intent(Chatroom.this, CartActivity.class);
                startActivity(i1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            case R.id.bell:
                startActivity(new Intent(Chatroom .this, Notification.class));
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