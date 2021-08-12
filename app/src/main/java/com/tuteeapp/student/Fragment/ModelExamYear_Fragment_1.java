package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tuteeapp.student.Adapter.Adapter_82_1;
import com.tuteeapp.student.ExamSubmit;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.Model_82_1;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ModelExamYear_Fragment_1 extends Fragment {
    RecyclerView rv_instruction;
    List<Model_82_1> model;
    Adapter_82_1 adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_model_exam_year1,container,false);

        model = new ArrayList<>();

        rv_instruction = view.findViewById(R.id.rv_instruction);
        rv_instruction.setHasFixedSize(true);
        rv_instruction.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        model.add(new Model_82_1("The question paper comprises three sections-A,B and C. Attempt all the sections."));
        model.add(new Model_82_1("All questions are compulsory."));
        model.add(new Model_82_1("Internel choice is given in each section."));
        model.add(new Model_82_1("The question paper comprises three sections-A,B and C. Attempt all the sections."));
        model.add(new Model_82_1("All questions are compulsory."));
        model.add(new Model_82_1("Internel choice is given in each section."));
        model.add(new Model_82_1("The question paper comprises three sections-A,B and C. Attempt all the sections."));
        model.add(new Model_82_1("All questions are compulsory."));
        model.add(new Model_82_1("Internel choice is given in each section."));
        adapter = new Adapter_82_1(getActivity(),model);
        rv_instruction.setAdapter(adapter);
        return view;
    }


}
