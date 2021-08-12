package com.tuteeapp.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class WelcomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    DotsIndicator indicator;
    //private int position = 0;
    Button btnnext;
    SlidingImage_Adapter slidingImage_adapter;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    TextView txt;
    PrefManager prefManager;
    int[] Images={R.drawable.page1,R.drawable.page2,R.drawable.page3,R.drawable.page4};
    String[] Text1={"TuteeApp Learning for K-12","Learning is fun with TuteeApp!",
            "Interactive Test & Preparation","Makes Learning Visual"};
    String[] Text2={"TuteeApp is a leading educational  technology apps for K-12 and Test (CBSE UK, O level).",
            "Ways Teachers can encourage passion for Learning this Semester.",
            "TuteeApp brings complex concepts to life and enables you to interact, engage and play with them.",
            "Tuteeapp makes learning visual complete syllabus coverage."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        prefManager = new PrefManager(this);
//        if (!prefManager.isFirstTimeLaunch()) {
//            launchHomeScreen();
//
//        }
        viewPager = findViewById(R.id.viewpager);
        indicator = findViewById(R.id.indicator);
        btnnext = findViewById(R.id.btnnext);

        slidingImage_adapter = new SlidingImage_Adapter(this);
        viewPager.setAdapter(slidingImage_adapter);
        indicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        NUM_PAGES = Images.length;


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int current = getItem(+1);
                if (current < Images.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    launchHomeScreen();
                }
            }
        });

    }
    private int getItem ( int i){
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            currentPage = position;
            if (position == Images.length - 1) {
                btnnext.setText("Get Started");
            } else {
                btnnext.setText("Next");
            }


        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void launchHomeScreen() {
//        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public class SlidingImage_Adapter extends PagerAdapter {
        private LayoutInflater inflater;
        private Context context;
        Resources res;

        public SlidingImage_Adapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object instantiateItem(ViewGroup view, final int position) {
            View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);

            assert imageLayout != null;
            final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.imageviewpager);
            final TextView txtView = (TextView) imageLayout.findViewById(R.id.text1);
            final TextView txtView2 = (TextView) imageLayout.findViewById(R.id.text2);
            imageView.setImageResource(Images[position]);
            txtView.setText(Text1[position]);
            txtView2.setText(Text2[position]);
            view.addView(imageLayout, 0);

            return imageLayout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

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