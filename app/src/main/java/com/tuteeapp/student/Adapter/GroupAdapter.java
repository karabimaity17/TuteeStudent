package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Model_Group;
import com.tuteeapp.student.R;
import com.tuteeapp.student.SingleGroup;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.Myholder> {
    ArrayList<Model_Group> arrayList;
    Context context;

    public GroupAdapter(ArrayList<Model_Group> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_group, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.imagesubject.setImageResource(arrayList.get(position).getImage());
        holder.textsubject.setText(arrayList.get(position).getText1());
        holder.textstudent.setText(arrayList.get(position).getText2());
        holder.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, SingleGroup.class));
            }
        });
        holder.type.setText(arrayList.get(position).getType());
        Drawable[] drawables = holder.type.getCompoundDrawables();

        if (arrayList.get(position).getType().equals("Online") ){
            if (drawables[2] != null) {  // left drawable
                drawables[2].setColorFilter(ContextCompat.getColor(context,R.color.green), PorterDuff.Mode.MULTIPLY);
            }
           // holder.type.getCompoundDrawablesRelative()[1].setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context,R.color.green), PorterDuff.Mode.SRC_IN));
        }else if (arrayList.get(position).getType().equals("") ){
            if (drawables[2] != null) {  // left drawable
                drawables[2].setColorFilter(ContextCompat.getColor(context,R.color.light_grey), PorterDuff.Mode.MULTIPLY);
            }
            //holder.type.getCompoundDrawablesRelative()[1].setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context,R.color.light_grey), PorterDuff.Mode.SRC_IN));
        }else{
            if (drawables[2] != null) {  // left drawable
                drawables[2].setColorFilter(ContextCompat.getColor(context,R.color.yellow), PorterDuff.Mode.MULTIPLY);
            }
            //holder.type.getCompoundDrawablesRelative()[1].setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context,R.color.yellow), PorterDuff.Mode.SRC_IN));
        }
        if (arrayList.get(position).getUnread().equals("Y")){
            holder.number.setVisibility(View.VISIBLE);
        }else {
            holder.number.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        ImageView imagesubject;
        TextView textsubject, textstudent,type;
        CardView card1,number;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            imagesubject = itemView.findViewById(R.id.imagesubject);
            textstudent = itemView.findViewById(R.id.textstudent);
            textsubject = itemView.findViewById(R.id.textsubject);
            card1 = itemView.findViewById(R.id.card1);
            type = itemView.findViewById(R.id.type);
            number = itemView.findViewById(R.id.number);
        }
    }
}
