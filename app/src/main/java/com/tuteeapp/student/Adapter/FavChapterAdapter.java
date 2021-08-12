package com.tuteeapp.student.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tuteeapp.student.ChapterActivity;
import com.tuteeapp.student.FavChapterVideo;
import com.tuteeapp.student.Model.FavChapterModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class FavChapterAdapter extends RecyclerView.Adapter<FavChapterAdapter.MyViewHolder> {

    Context context;
    List<FavChapterModel> model = new ArrayList<>();

    public FavChapterAdapter(Context context, List<FavChapterModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_fav_chapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.desc.setText(model.get(position).getDesc());
        holder.views.setText(model.get(position).getView());
        holder.subject.setText(model.get(position).getSubj());
        holder.lesson_code.setText(model.get(position).getLesson_code());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, FavChapterVideo.class));
            }
        });

        holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTransparent);
                View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_chapter_more, null);
                final CardView cardinfo = bottomSheetView.findViewById(R.id.info);
                final CardView cardsave = bottomSheetView.findViewById(R.id.cardsend);
                final CardView cardexercise = bottomSheetView.findViewById(R.id.exercise);
                final CardView cardanalysis = bottomSheetView.findViewById(R.id.analysis);
                final CardView cardtest = bottomSheetView.findViewById(R.id.test);
                CardView cancel = bottomSheetView.findViewById(R.id.btncancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView desc,subject,lesson_code,date,views,textViewOptions;
        ImageView img;
        CardView card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.desc);
            subject = itemView.findViewById(R.id.subject);
            lesson_code = itemView.findViewById(R.id.lesson_code);
            date = itemView.findViewById(R.id.date);
            views = itemView.findViewById(R.id.views);
            card = itemView.findViewById(R.id.card);
            img = itemView.findViewById(R.id.img);
            textViewOptions = itemView.findViewById(R.id.textViewOptions);

        }
    }
}
