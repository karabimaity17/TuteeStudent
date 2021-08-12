package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.ChapterTitle;
import com.tuteeapp.student.Model.FavChapterEbookModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class FavChapterEbookAdapter extends RecyclerView.Adapter<FavChapterEbookAdapter.MyViewHolder> {

    Context context;
    List<FavChapterEbookModel> model = new ArrayList<>();

    public FavChapterEbookAdapter(Context context, List<FavChapterEbookModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_fav_ebook, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.subject.setText(model.get(position).getSubject());
        //holder.chapter.setText(model.get(position).getChapter());
      //  holder.views.setText(model.get(position).getViews());

        holder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ChapterTitle.class));
            }
        });



    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subject,chapter,views;
        RelativeLayout rel;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subject = itemView.findViewById(R.id.number);
            chapter = itemView.findViewById(R.id.textchapter);
            views = itemView.findViewById(R.id.views);
            rel = itemView.findViewById(R.id.rel);

        }
    }
}
