package com.tuteeapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class RegisterActivity extends AppCompatActivity {
    Button btngetotp;
    TextView login;
    MaterialBetterSpinner code;
    String array[] = {"+91", "+81", "+71"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btngetotp = findViewById(R.id.btngetotp);
        login = findViewById(R.id.login);
        code = findViewById(R.id.code);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_spinner_dropdown_item, array);
        code.setAdapter(arrayAdapter);

        final SpannableStringBuilder sb = new SpannableStringBuilder("Already have an account ? Login Here");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(bss, 26, 36, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        login.setText(sb);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        btngetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, VerificationActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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