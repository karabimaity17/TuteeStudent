package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Model_Comments;
import com.tuteeapp.student.R;

import java.util.List;

public class Comment_Adapter extends RecyclerView.Adapter<Comment_Adapter.MyViewHolder> {


    Context context;
    List<Model_Comments> model_comments ;

    public Comment_Adapter(Context context, List<Model_Comments> model_comments) {
        this.context = context;
        this.model_comments = model_comments;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_comments, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text_person.setText(model_comments.get(position).getText_person());
        holder.text_comments.setText(model_comments.get(position).getText_comments());

    }

    @Override
    public int getItemCount() {
        return model_comments.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_person;
        TextView text_person,text_comments;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_person = itemView.findViewById(R.id.text_person);
            text_comments = itemView.findViewById(R.id.text_comments);
            img_person = itemView.findViewById(R.id.img_person);

        }
    }
}
