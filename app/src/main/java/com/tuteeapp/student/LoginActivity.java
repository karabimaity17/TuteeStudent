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
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnlogin;
    TextView register, textforgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnlogin = findViewById(R.id.btnlogin);
        register = findViewById(R.id.register);
        textforgot = findViewById(R.id.textforgot);

        final SpannableStringBuilder sb = new SpannableStringBuilder("Don't have an account ? Register Here");

        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(bss, 24, 37, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        register.setText(sb);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });
        textforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Resetpassword.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("page_type","login");
                Intent i = new Intent(LoginActivity.this, EduMe.class).putExtras(bundle);
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