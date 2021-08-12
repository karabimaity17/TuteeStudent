package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.Model_82_1;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_82_1 extends RecyclerView.Adapter<Adapter_82_1.MyViewHolder> {

    Context context;
    List<Model_82_1> model = new ArrayList<>();

    public Adapter_82_1(Context context, List<Model_82_1> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_82_1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text_instruction.setText(model.get(position).getText_instruction());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_instruction;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_instruction = itemView.findViewById(R.id.text_instruction);

        }
    }
}
