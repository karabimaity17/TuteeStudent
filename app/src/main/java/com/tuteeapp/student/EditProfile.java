package com.tuteeapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class EditProfile extends AppCompatActivity {
    Button btngetotp, btnnext;
    ImageView imageregister;
    LinearLayout llbtn;
    MaterialBetterSpinner code;
    String array[] = {"+91", "+81", "+71"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //  btnnext = findViewById(R.id.btnnext);
        btngetotp = findViewById(R.id.btngetotp);
        imageregister = findViewById(R.id.imageregister);
        //  llbtn = findViewById(R.id.llBtn);
        code = findViewById(R.id.code);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(EditProfile.this, android.R.layout.simple_dropdown_item_1line, array);
        code.setAdapter(arrayAdapter);

        //  llbtn.setVisibility(GONE);

        btngetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditProfile.this, EnterOtpActivity.class);
                startActivity(i);
                // llbtn.setVisibility(View.VISIBLE);
            }
        });
      /*  btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterSecond.this, EnterotpActivity10.class);
                startActivity(i);
            }
        });*/
        imageregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Intent i = new Intent(RegisterSecond.this, PhotoActivity12.class);
                //  startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {


            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        final Configuration override = new Configuration(newBase.getResources().getConfiguration());
        override.fontScale = 1.0f;
        applyOverrideConfiguration(override);
    }
}