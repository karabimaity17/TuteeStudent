package com.tuteeapp.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.tuteeapp.student.Fragment.FourthFragment;
import com.tuteeapp.student.Fragment.SecondFragment;
import com.tuteeapp.student.Fragment.ThirdFragment;
import com.tuteeapp.student.Fragment.FirstFragment;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class EnterDetails extends AppCompatActivity {
    ViewPager viewpager7;
    DotsIndicator indicator2;
    Button btnnext;
    SecondFragment.FragtoAct updatFrag;
    TextView textskip;
    int positions = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewpager7 = findViewById(R.id.viewpager7);
        indicator2 = findViewById(R.id.indicator2);
        btnnext = findViewById(R.id.btnnext);
        textskip = findViewById(R.id.textskip);

        Fragmentadapter fragmentadapter = new Fragmentadapter(getSupportFragmentManager());
        viewpager7.setAdapter(fragmentadapter);
        indicator2.setViewPager(viewpager7);

        textskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewpager7.setCurrentItem(positions + 2);
                if (positions < 3) {
                    viewpager7.setCurrentItem(positions + 1);
                } else {

                    Intent i = new Intent(EnterDetails.this, SelectGrade.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positions < 3) {
                    viewpager7.setCurrentItem(positions + 1);
                } else {
                    Intent i = new Intent(EnterDetails.this, SelectGrade.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                }
            }
        });
        viewpager7.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                positions = position;
                if (positions > 2) {
                    btnnext.setText("Demo");
                    textskip.setVisibility(View.GONE);
                } else {
                    btnnext.setText("Next");
                    textskip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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

    public void updateApi(SecondFragment.FragtoAct listener) {
        updatFrag= listener;
        viewpager7.setCurrentItem(positions-1);
    }

    public class Fragmentadapter extends FragmentPagerAdapter {
        public Fragmentadapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment f = null;

            if (position == 0) {
                f = new FirstFragment();
            }
            if (position == 1) {
                f = new SecondFragment();
            }
            if (position == 2) {
                f = new ThirdFragment();
            }
            if (position == 3) {
                f = new FourthFragment();
            }
            return f;
        }


        @Override
        public int getCount() {
            return 4;
        }
    }

}