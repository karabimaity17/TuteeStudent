package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.ExerciseReportModel;
import com.tuteeapp.student.Model.OptionModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseReportAdapter extends RecyclerView.Adapter<ExerciseReportAdapter.MyViewHolder> {

    Context context;
    List<ExerciseReportModel> model = new ArrayList<>();
    List<OptionModel> optionModels = new ArrayList<>();
OptionAdapter adapter;
    public ExerciseReportAdapter(Context context, List<ExerciseReportModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_exercise_report, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        optionModels= model.get(position).getModelList();
        holder.text.setText(model.get(position).getText());
        adapter = new OptionAdapter(context,optionModels);
        holder.rv_report_option.setHasFixedSize(true);
        holder.rv_report_option.setLayoutManager(new LinearLayoutManager(context));
        holder.rv_report_option.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        RecyclerView rv_report_option;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            rv_report_option = itemView.findViewById(R.id.rv_report_option);

        }
    }
    public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.MyViewHolder> {

        Context context;
        List<OptionModel> model = new ArrayList<>();

        public OptionAdapter(Context context, List<OptionModel> model) {
            this.context = context;
            this.model = model;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_exercise_report_option, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            holder.type.setText(model.get(position).getType());

            if (model.get(position).getType().equals("")){
                holder.type.setVisibility(View.GONE);
            }else if (model.get(position).getType().equals("C")){
                holder.type.setVisibility(View.VISIBLE);
                holder.type.setText("Correct");
                holder.type.setTextColor(Color.parseColor("#136517"));
            }else {
                holder.type.setVisibility(View.VISIBLE);
                holder.type.setText("Incorrect");
                holder.type.setTextColor(Color.RED);
            }


        }

        @Override
        public int getItemCount() {
            return model.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView type;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                type = itemView.findViewById(R.id.type);


            }
        }
    }

}
