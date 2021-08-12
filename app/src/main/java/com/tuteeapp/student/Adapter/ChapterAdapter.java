package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.LessonPlans;
import com.tuteeapp.student.Model.ChapterModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.Myholder> {
    ArrayList<ChapterModel> arrayList;
    Context context;

    public ChapterAdapter(ArrayList<ChapterModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_chapter_video, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.imageall.setImageResource(arrayList.get(position).getImage());
        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, LessonPlans.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        ImageView imageall;
        RelativeLayout rel;


        public Myholder(@NonNull View itemView) {
            super(itemView);
            imageall = itemView.findViewById(R.id.imageall);
            rel = itemView.findViewById(R.id.rel);
        }
    }
}
