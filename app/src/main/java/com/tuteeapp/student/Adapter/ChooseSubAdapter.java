package com.tuteeapp.student.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Model_Choosesub;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class ChooseSubAdapter extends RecyclerView.Adapter<ChooseSubAdapter.Myholder> {
    ArrayList<Model_Choosesub> arrayList;
    int row_index = -1;

    public ChooseSubAdapter(ArrayList<Model_Choosesub> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_choosesub, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholder holder, final int position) {
        holder.checkbox.setText(arrayList.get(position).getTextsubject());

        if (row_index == -1) {
            holder.btnradio.setBackgroundResource(R.drawable.radio_unselected);
            holder.textsub.setTextColor(Color.parseColor("#3e3e3e"));

        } else {
            if (row_index == position) {
                holder.btnradio.setBackgroundResource(R.drawable.radiobg);
                holder.textsub.setTextColor(Color.parseColor("#753abc"));


            } else {
                holder.btnradio.setBackgroundResource(R.drawable.radio_unselected);
                holder.textsub.setTextColor(Color.parseColor("#3e3e3e"));
            }
        }
      
        holder.btnradio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.textsub.setTextColor(Color.parseColor("#753abc"));
                holder.btnradio.setBackgroundResource(R.drawable.radiobg);
                if (row_index != position) {
                    notifyItemChanged(row_index);
                    row_index = position;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView textsub;
        RadioButton btnradio;
        CheckBox checkbox;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textsub = itemView.findViewById(R.id.textsub);
            btnradio = itemView.findViewById(R.id.btnradio);
            checkbox = itemView.findViewById(R.id.checkbox);
        }
    }
}
