package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Adapter.TestExamLibrary_Adapter;
import com.tuteeapp.student.Model.ExerciseLibrary_Model;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class TestExam_LibraryFragment extends Fragment {

    RecyclerView recycler_view;
    List<ExerciseLibrary_Model> exerciseLibrary_models;
    TestExamLibrary_Adapter exerciseLibrary_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_exam_library,container,false);

        exerciseLibrary_models =new ArrayList<>();

        recycler_view = view.findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recycler_view.setLayoutManager(linearLayoutManager);
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law","English","32654","Yesterday","N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law","English","32654","Yesterday","N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law","English","32654","Yesterday","N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law","English","32654","Yesterday","N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law","English","32654","Monday","Y"));
        exerciseLibrary_adapter = new TestExamLibrary_Adapter(getActivity(),exerciseLibrary_models);
        recycler_view.setAdapter(exerciseLibrary_adapter);
        return view;
    }
}
