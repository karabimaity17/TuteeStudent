package com.tuteeapp.student.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tuteeapp.student.ChapterActivity;
import com.tuteeapp.student.Model.ChapterLibraryModel;
import com.tuteeapp.student.Model.MonthModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.MyViewHolder> {

    Context context;
    List<MonthModel> model = new ArrayList<>();
    List<ChapterLibraryModel> chapterLibraryModels = new ArrayList<>();
ChapterLibraryAdapter adapter;
    public MonthAdapter(Context context, List<MonthModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_month, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        chapterLibraryModels= model.get(position).getChapterLibraryModels();
        holder.month.setText(model.get(position).getMonth());
        adapter = new ChapterLibraryAdapter(context,chapterLibraryModels);
        holder.rv_library.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView month;
        RecyclerView rv_library;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.month);
            rv_library = itemView.findViewById(R.id.rv_library);

        }
    }
    public class ChapterLibraryAdapter extends RecyclerView.Adapter<ChapterLibraryAdapter.MyViewHolder> {

        Context context;
        List<ChapterLibraryModel> model = new ArrayList<>();

        public ChapterLibraryAdapter(Context context, List<ChapterLibraryModel> model) {
            this.context = context;
            this.model = model;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_chapter_library, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.title.setText(model.get(position).getTitle());
            holder.subject.setText(model.get(position).getSubject());
            holder.lesson_code.setText(model.get(position).getLesson_code());
            holder.date.setText(model.get(position).getDate());
            holder.views.setText(model.get(position).getViews());
            if (model.get(position).getType().equals("L")){
                holder.card.setCardBackgroundColor(Color.WHITE);
                holder.img.setBackgroundResource(R.drawable.lock);
                holder.textViewOptions.setVisibility(View.GONE);
            }else if (model.get(position).getType().equals("O")){
                holder.card.setCardBackgroundColor(Color.WHITE);
                holder.img.setVisibility(View.GONE);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, ChapterActivity.class));
                    }
                });
                holder.textViewOptions.setVisibility(View.VISIBLE);
            }else {
                holder.textViewOptions.setVisibility(View.VISIBLE);
                holder.card.setCardBackgroundColor(Color.parseColor("#D9FADC"));
                holder.img.setBackgroundResource(R.drawable.unlock);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, ChapterActivity.class));
                    }
                });
            }
            holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTransparent);
                    View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_chapter_library, null);
                    final CardView cardinfo = bottomSheetView.findViewById(R.id.info);
                    final CardView cardsave = bottomSheetView.findViewById(R.id.cardsend);
                    final CardView cardexercise = bottomSheetView.findViewById(R.id.exercise);
                    final CardView cardanalysis = bottomSheetView.findViewById(R.id.analysis);
                    final CardView cardtest = bottomSheetView.findViewById(R.id.test);
                    CardView cancel = bottomSheetView.findViewById(R.id.cancel);
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

            TextView title,subject,lesson_code,date,views,textViewOptions;
            ImageView img;
            CardView card;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.title);
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

}
