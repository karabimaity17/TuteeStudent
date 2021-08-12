package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Classroom_Model;
import com.tuteeapp.student.R;


import java.util.ArrayList;
import java.util.List;

public class Classroom_Adapter extends RecyclerView.Adapter<Classroom_Adapter.MyViewHolder> {

    Context context;
    List<Classroom_Model> classroom_model = new ArrayList<>();

    public Classroom_Adapter(Context context, List<Classroom_Model> classroom_model) {
        this.context = context;
        this.classroom_model = classroom_model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_class, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.subj.setText(classroom_model.get(position).getSubj());
        holder.time.setText(classroom_model.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return classroom_model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView subj,time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            subj = itemView.findViewById(R.id.subj);
            time = itemView.findViewById(R.id.time);


        }
    }
}
