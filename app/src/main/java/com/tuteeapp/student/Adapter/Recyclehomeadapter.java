package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.ChapterActivity;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class Recyclehomeadapter extends RecyclerView.Adapter<Recyclehomeadapter.Myholder> {
    ArrayList<AllModel> alist;
    Context context;

    public Recyclehomeadapter(ArrayList<AllModel> alist, Context context) {
        this.alist = alist;
        this.context = context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_chapter, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.imageall.setImageResource(alist.get(position).getImage());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ChapterActivity.class);
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return alist.size();
    }

    public class Myholder extends RecyclerView.ViewHolder  {
        ImageView imageall;
        LinearLayout linear;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            imageall = itemView.findViewById(R.id.imageall);
            linear = itemView.findViewById(R.id.linear);

        }


    }
}
