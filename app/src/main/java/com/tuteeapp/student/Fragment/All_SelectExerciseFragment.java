package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.InviteToShare;
import com.tuteeapp.student.Model.ExerciseLibrary_Model;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class All_SelectExerciseFragment extends Fragment {
    RecyclerView rv_exercise;
    List<ExerciseLibrary_Model> exerciseLibrary_models;
    ExerciseLibrary_Adapter exerciseLibrary_adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_exercise, container, false);

        exerciseLibrary_models = new ArrayList<>();

        rv_exercise = view.findViewById(R.id.rv_exercise);
        rv_exercise.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv_exercise.setLayoutManager(linearLayoutManager);
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law", "English", "32654", "Yesterday", "N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law", "English", "32654", "Yesterday", "N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law", "English", "32654", "Yesterday", "N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law", "English", "32654", "Yesterday", "N"));
        exerciseLibrary_models.add(new ExerciseLibrary_Model("Content Forces and Newtons Law", "English", "32654", "Monday", "N"));
        exerciseLibrary_adapter = new ExerciseLibrary_Adapter(getActivity(), exerciseLibrary_models);
        rv_exercise.setAdapter(exerciseLibrary_adapter);


        return view;
    }

    public class ExerciseLibrary_Adapter extends RecyclerView.Adapter<ExerciseLibrary_Adapter.MyViewHolder> {

        Context context;
        List<ExerciseLibrary_Model> exerciseLibrary_models = new ArrayList<>();

        public ExerciseLibrary_Adapter(Context context, List<ExerciseLibrary_Model> exerciseLibrary_models) {
            this.context = context;
            this.exerciseLibrary_models = exerciseLibrary_models;
        }

        @NonNull
        @Override
        public ExerciseLibrary_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_select_exercise, parent, false);
            return new ExerciseLibrary_Adapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ExerciseLibrary_Adapter.MyViewHolder holder, int position) {

            holder.text_chapter.setText(exerciseLibrary_models.get(position).getText_chapter());
            holder.text_subj.setText(exerciseLibrary_models.get(position).getText_subj());
            holder.lesson_code.setText(exerciseLibrary_models.get(position).getLesson_code());
            holder.text_day.setText(exerciseLibrary_models.get(position).getText_day());
            holder.card_exercise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, InviteToShare.class));
                    getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            });
            if (exerciseLibrary_models.get(position).getChecked().equals("Y")) {
                holder.action.setVisibility(View.VISIBLE);
                holder.card_exercise.setCardBackgroundColor(Color.parseColor("#D9FADC"));
            } else {
                holder.action.setVisibility(View.GONE);
                holder.card_exercise.setCardBackgroundColor(Color.WHITE);
            }
        }

        @Override
        public int getItemCount() {
            return exerciseLibrary_models.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text_chapter, text_subj, lesson_code, text_day;
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
}