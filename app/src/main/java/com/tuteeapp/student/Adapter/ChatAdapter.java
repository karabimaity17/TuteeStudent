package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.tuteeapp.student.Chatroom;
import com.tuteeapp.student.Model.AllChatModel;
import com.tuteeapp.student.Model.Model_82_1;
import com.tuteeapp.student.R;
import com.tuteeapp.student.SingleGroup;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    Context context;
    List<AllChatModel> model = new ArrayList<>();

    public ChatAdapter(Context context, List<AllChatModel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_chat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (model.get(position).getCount().equals("0")){
            holder.card_count.setVisibility(View.GONE);
        }else {
            holder.txt_count.setText(model.get(position).getCount());
            holder.card_count.setVisibility(View.VISIBLE);
        }
        holder.lin_chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, Chatroom.class));
            }
        });
        holder.textViewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTransparent);
                View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_chatroom, null);

                CardView cancel = bottomSheetView.findViewById(R.id.cancel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_count,textViewOptions;
        CardView card_count;
        LinearLayout lin_chats;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card_count = itemView.findViewById(R.id.card_count);
            txt_count = itemView.findViewById(R.id.txt_count);
            lin_chats = itemView.findViewById(R.id.lin_chats);
            textViewOptions = itemView.findViewById(R.id.textViewOptions);

        }
    }
}
