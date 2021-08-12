package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Adapter.ChapterEbookAdapter;
import com.tuteeapp.student.ChapterEbook;
import com.tuteeapp.student.ChapterTitle;
import com.tuteeapp.student.Model.ChapterEbookModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityBinEBook_Fragment extends Fragment {

    RecyclerView rv_video;
    ArrayList<ChapterEbookModel> arrayList = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activitybin_video,container,false);

        rv_video = view.findViewById(R.id.rv_video);
        rv_video.setHasFixedSize(true);
        rv_video.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        arrayList.add(new ChapterEbookModel( "ENG"));
        arrayList.add(new ChapterEbookModel( "ENG"));
        arrayList.add(new ChapterEbookModel( "ENG"));
        arrayList.add(new ChapterEbookModel( "ENG"));
        arrayList.add(new ChapterEbookModel( "ENG"));
        arrayList.add(new ChapterEbookModel( "ENG"));
        rv_video.setAdapter(new ChapterEbookAdapter(arrayList, getActivity()));


        return view;
    }

    public class ChapterEbookAdapter extends RecyclerView.Adapter<ChapterEbookAdapter.Myholder> {
        ArrayList<ChapterEbookModel> arrayList;
        Context context;

        public ChapterEbookAdapter(ArrayList<ChapterEbookModel> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.single_video2, parent, false);
            Myholder myholder = new Myholder(view);
            return myholder;
        }

        @Override
        public void onBindViewHolder(@NonNull Myholder holder, int position) {
            //holder.img.setImageResource(arrayList.get(position).getImage());
//            holder.chapter_title.setText(badge_models.get(position).getChapter_title());
//            holder.time.setText(badge_models.get(position).getTime());
//            holder.desc.setText(badge_models.get(position).getDesc());
//            holder.subj.setText(badge_models.get(position).getSubj());
//            holder.lesson_code.setText(badge_models.get(position).getLesson_code());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class Myholder extends RecyclerView.ViewHolder {
            ImageView img;
            TextView chapter_title,time,desc,subj,lesson_code;
            public Myholder(@NonNull View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.img);
                chapter_title = itemView.findViewById(R.id.chapter_title);
                time = itemView.findViewById(R.id.time);
                desc = itemView.findViewById(R.id.desc);
                subj = itemView.findViewById(R.id.subj);
                lesson_code = itemView.findViewById(R.id.lesson_code);
            }
        }
    }

}
