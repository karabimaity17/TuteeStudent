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

import com.tuteeapp.student.Adapter.MonthAdapter;
import com.tuteeapp.student.Adapter.PageAdapter;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.ChapterLibraryModel;
import com.tuteeapp.student.Model.MonthModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityBinChapter_Library_Fragment extends Fragment {
  //  private ViewPager viewPager;
  //  ViewPagerAdapter viewPagerAdapter;
    PageAdapter pageAdapter;
    PageAdapter.callback indicatorCallback;
    RecyclerView rv_page;
    TextView next;
    private static int currentPage = 0;
    ArrayList<AllModel> arrayList = new ArrayList();
    private List<Fragment> fragments = new ArrayList<>();

    RecyclerView rv_classes;
    List<MonthModel> MonthModel;
    List<ChapterLibraryModel> model;
    MonthAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chapter_library,container,false);

        rv_page = view.findViewById(R.id.rv_page);


        //viewPager = view.findViewById(R.id.viewpager);

        next = view.findViewById(R.id.next);

      //  viewPager.setPageTransformer(true,null);

        arrayList.add(new AllModel("1"));
        arrayList.add(new AllModel("2"));
        arrayList.add(new AllModel("3"));
        arrayList.add(new AllModel("4"));
        arrayList.add(new AllModel("5"));
        arrayList.add(new AllModel("6"));
        arrayList.add(new AllModel("7"));
        arrayList.add(new AllModel("8"));
        indicatorCallback = new PageAdapter.callback() {
            @Override
            public void onTitleClicked(int position) {
                currentPage = position;

                if (currentPage < arrayList.size()) {
                    pageAdapter.setSelectedIndex(currentPage);
                    pageAdapter.notifyDataSetChanged();
                    rv_page.scrollToPosition(currentPage);
                }else {
                    next.setVisibility(View.GONE);
                }
            }
        };
        pageAdapter = new PageAdapter(getActivity(),arrayList,indicatorCallback);
        rv_page.setAdapter(pageAdapter);

        MonthModel = new ArrayList<>();
        model = new ArrayList<>();

        rv_classes = view.findViewById(R.id.rv_classes);
        rv_classes.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        rv_classes.setLayoutManager(linearLayoutManager);
        model.add(new ChapterLibraryModel("Content Forces and Newtons Law","English","Lesson code : 32654","05.10.2020","View 132","O"));
        model.add(new ChapterLibraryModel("Content Forces and Newtons Law","English","Lesson code : 32654","05.10.2020","View 132","O"));
        model.add(new ChapterLibraryModel("Content Forces and Newtons Law","English","Lesson code : 32654","05.10.2020","View 132","O"));
        MonthModel.add(new MonthModel("February",model));
        MonthModel.add(new MonthModel("January",model));
        adapter = new MonthAdapter(getActivity(),MonthModel);
        rv_classes.setAdapter(adapter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentPage = currentPage+1;

                if (currentPage < arrayList.size()) {
                    pageAdapter.setSelectedIndex(currentPage);
                    pageAdapter.notifyDataSetChanged();
                    rv_page.scrollToPosition(currentPage);
                }else {
                    next.setVisibility(View.GONE);
                }


            }
        });
        return view;
    }




}
