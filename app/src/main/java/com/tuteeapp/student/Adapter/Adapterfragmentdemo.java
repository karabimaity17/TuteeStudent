package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Model_demo22;
import com.tuteeapp.student.R;
import com.tuteeapp.student.TitleDemo;

import java.util.ArrayList;

public class Adapterfragmentdemo extends RecyclerView.Adapter<Adapterfragmentdemo.Myholder> {
    Context context;
    ArrayList<Model_demo22> arrayList;


    public Adapterfragmentdemo(Context context, ArrayList<Model_demo22> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_ebook, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
       holder.textchapter.setText(arrayList.get(position).getChapter());
       holder.textnumber.setText(arrayList.get(position).getNumber());
       holder.rel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               context.startActivity(new Intent(context, TitleDemo.class));

           }
       });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView textchapter,textnumber;
        RelativeLayout rel;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textchapter = itemView.findViewById(R.id.textchapter);
            textnumber = itemView.findViewById(R.id.textnumber);
            rel = itemView.findViewById(R.id.rel);

        }

    }
}
