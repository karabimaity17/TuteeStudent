package com.tuteeapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class StudentActivity extends AppCompatActivity {
    ImageView imagestudent, imagecheck;
    Button btngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imagestudent = findViewById(R.id.imagestudent);
        imagecheck = findViewById(R.id.imagecheck);
        btngo = findViewById(R.id.btngo);

        btngo.setEnabled(false);
        imagecheck.setVisibility(View.GONE);

        imagestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btngo.setEnabled(true);
                imagecheck.setVisibility(View.VISIBLE);
                imagestudent.setVisibility(View.GONE);
                btngo.setBackgroundResource(R.drawable.btnbackground);
                btngo.setTextColor(getApplication().getResources().getColor(R.color.white));
            }
        });
        imagecheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagestudent.setVisibility(View.VISIBLE);
                imagecheck.setVisibility(View.GONE);
                btngo.setEnabled(false);
                btngo.setBackgroundResource(R.drawable.bg_whitebackground);
                btngo.setTextColor(getApplication().getResources().getColor(R.color.grey));
            }
        });
        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(StudentActivity.this, WelcomeActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

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