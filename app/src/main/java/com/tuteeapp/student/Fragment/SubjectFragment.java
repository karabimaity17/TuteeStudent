package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Adapter.LessonPlanAdapter;
import com.tuteeapp.student.Adapter.PopularVideoAdapter;
import com.tuteeapp.student.Model.LessonPlanModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;


public class SubjectFragment extends Fragment {
    RecyclerView rv1, rv2;
    ArrayList<LessonPlanModel> alist = new ArrayList<>();
    ArrayList<LessonPlanModel> glist = new ArrayList<>();
    //int array[] = {R.drawable.image6, R.drawable.image4, R.drawable.image1};
    // int photo[] = {R.drawable.image5, R.drawable.image3, R.drawable.image1};

    public SubjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_horizontal, container, false);
        alist.add(new LessonPlanModel(R.drawable.image1, "ENG"));
        alist.add(new LessonPlanModel(R.drawable.image2, "PHY"));
        alist.add(new LessonPlanModel(R.drawable.image3, "BST"));

        glist.add(new LessonPlanModel(R.drawable.image1, "ENG"));
        glist.add(new LessonPlanModel(R.drawable.image2, "PHY"));
        glist.add(new LessonPlanModel(R.drawable.image3, "BST"));


        rv1 = view.findViewById(R.id.rv1);
        rv2 = view.findViewById(R.id.rv2);
        rv1.setAdapter(new LessonPlanAdapter(alist,getActivity()));
        rv2.setAdapter(new PopularVideoAdapter(glist,getActivity()));
        return view;
    }
}