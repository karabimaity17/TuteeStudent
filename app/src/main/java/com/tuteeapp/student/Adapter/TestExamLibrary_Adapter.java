package com.tuteeapp.student.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.ExerciseLibrary_Model;
import com.tuteeapp.student.R;
import com.tuteeapp.student.TestExam;

import java.util.ArrayList;
import java.util.List;

public class TestExamLibrary_Adapter extends RecyclerView.Adapter<TestExamLibrary_Adapter.MyViewHolder> {

    Context context;
    List<ExerciseLibrary_Model> exerciseLibrary_models = new ArrayList<>();

    public TestExamLibrary_Adapter(Context context, List<ExerciseLibrary_Model> exerciseLibrary_models) {
        this.context = context;
        this.exerciseLibrary_models = exerciseLibrary_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_exercise_library, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text_chapter.setText(exerciseLibrary_models.get(position).getText_chapter());
        holder.text_subj.setText(exerciseLibrary_models.get(position).getText_subj());
        holder.lesson_code.setText(exerciseLibrary_models.get(position).getLesson_code());
        holder.text_day.setText(exerciseLibrary_models.get(position).getText_day());

        if (exerciseLibrary_models.get(position).getChecked().equals("Y")){
            holder.action.setVisibility(View.VISIBLE);
            holder.card_exercise.setCardBackgroundColor(Color.parseColor("#D9FADC"));
        }else {
            holder.action.setVisibility(View.GONE);
            holder.card_exercise.setCardBackgroundColor(Color.WHITE);
            holder.card_exercise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, TestExam.class));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return exerciseLibrary_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_chapter,text_subj,lesson_code,text_day;
        CardView card_exercise;
        ImageView action;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_chapter = itemView.findViewById(R.id.text_chapter);
            text_subj = itemView.findViewById(R.id.text_subj);
            lesson_code = itemView.findViewById(R.id.lesson_code);
            text_day = itemView.findViewById(R.id.text_day);
            card_exercise = itemView.findViewById(R.id.card_exercise);
            action = itemView.findViewById(R.id.action);

        }
    }
}
