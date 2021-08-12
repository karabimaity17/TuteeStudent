package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Adapter.LessonPlanAdapter;
import com.tuteeapp.student.Model.LessonPlanModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;


public class AllLesson_Fragment extends Fragment {

    RecyclerView rv;
    ArrayList<LessonPlanModel> arrayList = new ArrayList();

    public AllLesson_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_lesson, container, false);
        rv = view.findViewById(R.id.rv);
        rv.setAdapter(new LessonPlanAdapter(arrayList,getActivity()));
        arrayList.add(new LessonPlanModel(R.drawable.image1, "ENG"));
        arrayList.add(new LessonPlanModel(R.drawable.image2, "PHY"));
        arrayList.add(new LessonPlanModel(R.drawable.image3, "BST"));
        arrayList.add(new LessonPlanModel(R.drawable.image4, "BIO"));
        arrayList.add(new LessonPlanModel(R.drawable.image5, "PHY"));
        arrayList.add(new LessonPlanModel(R.drawable.image6, "CHE"));
        return view;
    }
}