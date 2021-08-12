package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Badge_Model;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class Badge_Adapter extends RecyclerView.Adapter<Badge_Adapter.MyViewHolder> {

    Context context;
    List<Badge_Model> badge_models = new ArrayList<>();

    public Badge_Adapter(Context context, List<Badge_Model> badge_models) {
        this.context = context;
        this.badge_models = badge_models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_badges, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.img_badge.setImageResource(badge_models.get(position).getImage());
        holder.text.setText(badge_models.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return badge_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_badge;
        TextView text;
        LinearLayout linear_badge;
        //        LinearLayout linear_this;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_badge = itemView.findViewById(R.id.img_badge);
            text = itemView.findViewById(R.id.text);
            linear_badge = itemView.findViewById(R.id.linear_badge);
//            linear_this = itemView.findViewById(R.id.linear_all_ques);

        }
    }
}
