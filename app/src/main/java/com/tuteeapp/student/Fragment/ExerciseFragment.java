package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tuteeapp.student.R;


public class ExerciseFragment extends Fragment {
    String val;
    RelativeLayout relative_completed;
   //TextView btn_submit;
    View view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        val = getArguments() != null ? getArguments().getString("id") : "";

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exercise_fragment,container,false);

        relative_completed=view.findViewById(R.id.relative_completed);
       // btn_submit=view.findViewById(R.id.btn_submit);

        if (!val.equals("1")){
            relative_completed.setVisibility(View.GONE);
        }else {
            relative_completed.setVisibility(View.VISIBLE);
        }

        return view;
    }
    public static ExerciseFragment newInstance(String val) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putString("id", val);
        fragment.setArguments(args);
        return fragment;
    }

}
