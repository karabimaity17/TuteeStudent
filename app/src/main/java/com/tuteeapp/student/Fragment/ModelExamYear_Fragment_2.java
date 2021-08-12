package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tuteeapp.student.Adapter.Adapter_82_2;
import com.tuteeapp.student.ExamSubmit;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.Model_82_2;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ModelExamYear_Fragment_2 extends Fragment {
    RecyclerView rv_question;
    List<Model_82_2> model;
    Adapter_82_2 adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_model_exam_year2,container,false);

        model = new ArrayList<>();

        rv_question = view.findViewById(R.id.rv_question);
        rv_question.setHasFixedSize(true);
        rv_question.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        model.add(new Model_82_2("01","Match the following items given in Column A with those in Column B. Choose the correct answer from the options given below:",
                "A. Rashsundari Devi","B. Rashsundari Devi","C. Rashsundari Devi","D. Rashsundari Devi",
                "A. Chhote Aur Baade","B. Chhote Aur Baade","C. Chhote Aur Baade","D. Chhote Aur Baade"));
        adapter = new Adapter_82_2(getActivity(),model);
        rv_question.setAdapter(adapter);
        return view;
    }

}
