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


import com.tuteeapp.student.Adapter.FavChapterAdapter;
import com.tuteeapp.student.Model.FavChapterModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class FavChapterFragment extends Fragment {

    RecyclerView rv_favourite;
    List<FavChapterModel> model;
    FavChapterAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav_chapter,container,false);

        model = new ArrayList<>();

        rv_favourite = view.findViewById(R.id.rv_favourite);
        rv_favourite.setHasFixedSize(true);
        rv_favourite.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        model.add(new FavChapterModel("Chapter title", "","Content forces and newton law","View 132","English","Lesson Code: 03546"));
        model.add(new FavChapterModel("Chapter title", "Yesterday","Content forces and newton law","View 132","English","Lesson Code: 03546"));
        model.add(new FavChapterModel("Chapter title", "Yesterday","Content forces and newton law","View 132","English","Lesson Code: 03546"));
        model.add(new FavChapterModel("Chapter title", "Monday","Content forces and newton law","View 132","English","Lesson Code: 03546"));
        model.add(new FavChapterModel("Chapter title", "12/04/2020","Content forces and newton law","View 132","English","Lesson Code: 03546"));
        adapter = new FavChapterAdapter(getActivity(),model);
        rv_favourite.setAdapter(adapter);

        return view;
    }
}
