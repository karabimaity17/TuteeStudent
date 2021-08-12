package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;



import com.tuteeapp.student.Adapter.Adapterfragmentdemo;
import com.tuteeapp.student.Model.Model_demo22;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class FragmentDemo extends Fragment {
    RecyclerView rv;
    ArrayList<Model_demo22> alist=new ArrayList<>();
    //String array[] = {"Chapter\n Title 1", "Chapter\n Title 2", "Chapter\n Title 3", "Chapter\n Title 4", "Chapter\n Title 5", "Chapter\n Title 6"};

    public FragmentDemo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        rv = view.findViewById(R.id.rv);
        alist.add(new Model_demo22("Chapter\n Title 1","1"));
        alist.add(new Model_demo22("Chapter\n Title 2","2"));
        alist.add(new Model_demo22("Chapter\n Title 3","3"));
        alist.add(new Model_demo22("Chapter\n Title 4","4"));
        alist.add(new Model_demo22("Chapter\n Title 5","5"));
        alist.add(new Model_demo22("Chapter\n Title 6","6"));

        Adapterfragmentdemo adapterfragmentdemo = new Adapterfragmentdemo(getActivity(), alist);
        rv.setAdapter(adapterfragmentdemo);
        return view;
    }


}