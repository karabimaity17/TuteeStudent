package com.tuteeapp.student.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tuteeapp.student.Adapter.ModelExamAdapter;
import com.tuteeapp.student.Adapter.PageAdapter;
import com.tuteeapp.student.Adapter.QuestionAdapter;
import com.tuteeapp.student.Assignments;
import com.tuteeapp.student.Classroom;
import com.tuteeapp.student.ExamSubmit;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.Model_Exam;
import com.tuteeapp.student.Model.QuestionModel;
import com.tuteeapp.student.ModelExam;
import com.tuteeapp.student.R;
import com.tuteeapp.student.SubjectTiming;
import com.tuteeapp.student.TestExam;

import java.util.ArrayList;
import java.util.List;

public class ModelExamYear_Fragment extends Fragment {
    View view;
    ArrayList<AllModel> arrayList = new ArrayList();
     PageAdapter pageAdapter;
    RecyclerView rv_page;
    TextView submit;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_model_exam_year,container,false);

        rv_page = view.findViewById(R.id.rv_page);
        submit = view.findViewById(R.id.submit);
        viewPager = view.findViewById(R.id.viewpager);

        viewPager.setPageTransformer(true,null);

        arrayList.add(new AllModel("1"));
        arrayList.add(new AllModel("2"));
        arrayList.add(new AllModel("3"));
        arrayList.add(new AllModel("4"));
        arrayList.add(new AllModel("5"));
        pageAdapter = new PageAdapter(getActivity(),arrayList/*,indicatorCallback*/,ModelExamYear_Fragment.this);
        rv_page.setAdapter(pageAdapter);


        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View arg0, MotionEvent arg1) {
                return true;
            }
        });

        return view;
    }

    public static class PageAdapter extends RecyclerView.Adapter<PageAdapter.Myholder> {
        Context context;
        ArrayList<AllModel> arrayList2;
        private int selectedIndex;
        ModelExamYear_Fragment fragment;

        public PageAdapter(Context context, ArrayList<AllModel> arrayList2,ModelExamYear_Fragment fragment) {
            this.context = context;
            this.arrayList2 = arrayList2;
            selectedIndex=0;
            this.fragment = fragment;
        }
        @NonNull
        @Override
        public PageAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.selected_page2, parent, false);
            PageAdapter.Myholder myholder = new PageAdapter.Myholder(view);
            return myholder;
        }

        @Override
        public void onBindViewHolder(@NonNull final PageAdapter.Myholder holder, final int position) {
            holder.number.setText(arrayList2.get(position).getNumber());
            if (position==0){
                holder.steps.setVisibility(View.GONE);
                holder.number.setBackgroundResource(R.drawable.btnbackground2);
                holder.steps.setTextColor(ContextCompat.getColor(context,R.color.purple));

            }else{
                holder.steps.setVisibility(View.VISIBLE);
            }
            if(selectedIndex == position ){
                holder.number.setBackgroundResource(R.drawable.btnbackground2);
                holder.steps.setTextColor(ContextCompat.getColor(context,R.color.purple));

            }

           fragment.submit.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (selectedIndex < position-1) {
                       selectedIndex = selectedIndex+1;
                       fragment.viewPager.setCurrentItem(selectedIndex);
                       fragment.pageAdapter.notifyDataSetChanged();
                       fragment.submit.setText("Next");
                   }else if(selectedIndex == position-1){
                       selectedIndex = selectedIndex+1;
                       fragment.viewPager.setCurrentItem(selectedIndex);
                       fragment.pageAdapter.notifyDataSetChanged();
                      fragment.submit.setText("Submit");

                   }else if(selectedIndex==position){
                       AlertDialog.Builder builder = new AlertDialog.Builder(context);
                       LayoutInflater inflater = LayoutInflater.from(context);
                       final View dialogView = inflater.inflate(R.layout.popup_submit_modelexam, null);
                       final Button button = dialogView.findViewById(R.id.button);

                       builder.setView(dialogView);
                       final AlertDialog alert = builder.create();
                       alert.setCanceledOnTouchOutside(true);
                       alert.show();
                       button.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               context.startActivity(new Intent(context, ModelExam.class));
                               alert.dismiss();

                           }
                       });

                   }

               }
           });

        }


        @Override
        public int getItemCount() {
            return arrayList2.size();
        }

        public class Myholder extends RecyclerView.ViewHolder{
            TextView number,steps;


            public Myholder(@NonNull View itemView) {
                super(itemView);
                number = itemView.findViewById(R.id.number);
                steps = itemView.findViewById(R.id.steps);

            }

        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {


        ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            Fragment resto=null;
            if (position==0){
                resto = new ModelExamYear_Fragment_1();
            }else if (position==1){
                resto = new ModelExamYear_Fragment_2();
            }else if (position==2){
                resto = new ModelExamYear_Fragment_3();
            }else if (position==3){
                resto = new ModelExamYear_Fragment_3();
            }else if (position==4){
                resto = new ModelExamYear_Fragment_3();
            }

            // resto.setRestaurant(arrayList.get(position).getNumber());
            return resto;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

    }
}
