package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.Model_Notification;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.MyViewHolder> {

    Context context;
    List<Model_Notification> model = new ArrayList<>();

    public Notification_Adapter(Context context, List<Model_Notification> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_notification, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.text_name.setText(model.get(position).getText_name());
        holder.board.setText(model.get(position).getBoard());
        holder.desc.setText(model.get(position).getDesc());
        holder.image.setImageResource(model.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_name,board,desc;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_name = itemView.findViewById(R.id.text_name);
            board = itemView.findViewById(R.id.board);
            desc = itemView.findViewById(R.id.desc);
            image = itemView.findViewById(R.id.image);

        }
    }
}
