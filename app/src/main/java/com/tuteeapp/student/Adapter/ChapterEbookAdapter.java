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

import com.tuteeapp.student.ChapterTitle;
import com.tuteeapp.student.Model.ChapterEbookModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;

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
        View view = layoutInflater.inflate(R.layout.single_chapter_ebook, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ChapterTitle.class));
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
            rel = itemView.findViewById(R.id.rel);
        }
    }
}
