package com.tuteeapp.student.Fragment;

import android.content.Context;
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


import com.tuteeapp.student.Model.ChapterModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityBinVideo_Fragment extends Fragment {

    RecyclerView rv_video;
    List<ChapterModel> arrayList;
    ChapterAdapter video_adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activitybin_video,container,false);

        arrayList = new ArrayList<>();

        rv_video = view.findViewById(R.id.rv_video);
        rv_video.setHasFixedSize(true);
        rv_video.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        arrayList.add(new ChapterModel(R.drawable.image1, "ENG"));
        arrayList.add(new ChapterModel(R.drawable.image2, "ENG"));
        arrayList.add(new ChapterModel(R.drawable.image3, "ENG"));
        arrayList.add(new ChapterModel(R.drawable.image4, "ENG"));
        arrayList.add(new ChapterModel(R.drawable.image5, "ENG"));
        arrayList.add(new ChapterModel(R.drawable.image6, "ENG"));
        video_adapter = new ChapterAdapter(arrayList,getActivity());
        rv_video.setAdapter(video_adapter);


        return view;
    }

    public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.Myholder> {
        List<ChapterModel> arrayList;
        Context context;

        public ChapterAdapter(List<ChapterModel> arrayList, Context context) {
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
            holder.img.setImageResource(arrayList.get(position).getImage());
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
