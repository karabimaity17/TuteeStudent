package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Adapter.ModelExamAdapter;
import com.tuteeapp.student.Adapter.MonthAdapter;
import com.tuteeapp.student.Adapter.PageAdapter;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.ChapterLibraryModel;
import com.tuteeapp.student.Model.Model_Exam;
import com.tuteeapp.student.Model.MonthModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ModelExam_Fragment extends Fragment {
    RecyclerView rv_exam;
    List<Model_Exam> model = new ArrayList<>();
    ModelExamAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_model_exam,container,false);

        model = new ArrayList<>();

        rv_exam = view.findViewById(R.id.rv_exam);
        rv_exam.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv_exam.setLayoutManager(linearLayoutManager);
        model.add(new Model_Exam("Final","","Exam Date: 19.12.20","L"));
        model.add(new Model_Exam("3rd Term","Percentile 89%","Exam Date: 19.12.20","L"));
        model.add(new Model_Exam("2nd Term","Percentile 89%","Exam Date: 19.12.20","U"));
        model.add(new Model_Exam("1st Term","Percentile 89%","Exam Date: 19.12.20","U"));
        adapter = new ModelExamAdapter(getActivity(),model);
        rv_exam.setAdapter(adapter);

        return view;
    }




}
