package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.GradeModel;
import com.tuteeapp.student.R;

import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.Myholder> {

    int row_index = -1;
    Context context;
    List<GradeModel> gradeModelList;

    public GradeAdapter(Context context, List<GradeModel> gradeModelList) {
        this.context = context;
        this.gradeModelList = gradeModelList;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_grade, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.text_grade.setText(gradeModelList.get(position).getText_grade());
        holder.text_student.setText(gradeModelList.get(position).getText_student());
        holder.bind(gradeModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return gradeModelList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView text_grade, text_student, text;
        LinearLayout linear1;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            text_grade = itemView.findViewById(R.id.text_grade);
            text_student = itemView.findViewById(R.id.text_student);
            linear1 = itemView.findViewById(R.id.linear1);

        }

        public void bind(GradeModel model) {
            if (row_index == -1) {
                linear1.setBackgroundResource(R.drawable.whiteback2);
                text_grade.setTextColor(Color.parseColor("#753abc"));
                text_student.setTextColor(Color.parseColor("#7e7e7e"));
                text.setTextColor(Color.parseColor("#7e7e7e"));
            } else {
                if (row_index == getAdapterPosition()) {
                    linear1.setBackgroundResource(R.drawable.light_background);
                    text_grade.setTextColor(Color.parseColor("#ffffff"));
                    text_student.setTextColor(Color.parseColor("#ffffff"));
                    text.setTextColor(Color.parseColor("#ffffff"));


                } else {
                    linear1.setBackgroundResource(R.drawable.whiteback2);
                    text_grade.setTextColor(Color.parseColor("#753abc"));
                    text_student.setTextColor(Color.parseColor("#7e7e7e"));
                    text.setTextColor(Color.parseColor("#7e7e7e"));
                }
            }

            linear1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    linear1.setBackgroundResource(R.drawable.light_background);
                    text_grade.setTextColor(Color.parseColor("#ffffff"));
                    text_student.setTextColor(Color.parseColor("#ffffff"));
                    text.setTextColor(Color.parseColor("#ffffff"));
                    if (row_index != getAdapterPosition()) {
                        notifyItemChanged(row_index);
                        row_index = getAdapterPosition();
                    }

                }
            });
        }
    }
}
