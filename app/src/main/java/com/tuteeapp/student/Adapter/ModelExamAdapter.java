package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.Model_Exam;
import com.tuteeapp.student.ModelExam;
import com.tuteeapp.student.ModelExamYear;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ModelExamAdapter  extends RecyclerView.Adapter<ModelExamAdapter.MyViewHolder> {

    int row_index = -1;
    Context context;
    List<Model_Exam> model = new ArrayList<>();

    public ModelExamAdapter(Context context, List<Model_Exam> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_model_exam, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.text_term.setText(model.get(position).getText_term());
        holder.text_date.setText(model.get(position).getText_date());
        if (model.get(position).getType().equals("L")){
            holder.linear_exam.setBackgroundColor(ContextCompat.getColor(context, R.color.light_green2));
            holder.text_term.setTextColor(ContextCompat.getColor(context, R.color.green));
            holder.text_date.setTextColor(ContextCompat.getColor(context, R.color.grey));
            holder.text_percentile.setTextColor(ContextCompat.getColor(context, R.color.green));
            holder.view_report.setTextColor(ContextCompat.getColor(context, R.color.colorSky));
            holder.img_tick.setVisibility(View.VISIBLE);
        }else{
            holder.linear_exam.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
            holder.text_term.setTextColor(ContextCompat.getColor(context, R.color.black));
            holder.text_date.setTextColor(ContextCompat.getColor(context, R.color.grey));
            holder.text_percentile.setTextColor(ContextCompat.getColor(context, R.color.white));
            holder.view_report.setTextColor(ContextCompat.getColor(context, R.color.grey));
            holder.img_tick.setVisibility(View.GONE);
        }



        holder.linear_exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                row_index=position;
                context.startActivity(new Intent(context, ModelExamYear.class));
            }
        });


    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_term,text_date,text_percentile,view_report;
        LinearLayout linear_exam;
        ImageView img_tick;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_term = itemView.findViewById(R.id.text_term);
            text_date = itemView.findViewById(R.id.text_date);
            text_percentile = itemView.findViewById(R.id.text_percentile);
            view_report = itemView.findViewById(R.id.view_report);
            linear_exam = itemView.findViewById(R.id.linear_exam);
            img_tick = itemView.findViewById(R.id.img_tick);
        }
    }
}

