package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.FavChapterVideoModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class FavChapterVideoAdapter extends RecyclerView.Adapter<FavChapterVideoAdapter.MyViewHolder> {

    Context context;
    List<FavChapterVideoModel> model = new ArrayList<>();

    public FavChapterVideoAdapter(Context context, List<FavChapterVideoModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_favourite_video, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //holder.views.setText(model.get(position).getViews());
     //   holder.chapter.setText(model.get(position).getChapter());
        holder.subject.setText(model.get(position).getSubject());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView views,chapter,subject;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            views = itemView.findViewById(R.id.views);
            chapter = itemView.findViewById(R.id.chapter);
            subject = itemView.findViewById(R.id.number);
            img = itemView.findViewById(R.id.imageall);

        }
    }
}
