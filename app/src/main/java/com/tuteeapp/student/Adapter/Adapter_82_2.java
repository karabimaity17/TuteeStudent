package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.Model.Model_82_2;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_82_2 extends RecyclerView.Adapter<Adapter_82_2.MyViewHolder> {

    Context context;
    List<Model_82_2> model = new ArrayList<>();
    List<AllModel> mcq_model = new ArrayList<>();
    MCqAdapter mCqAdapter;

    public Adapter_82_2(Context context, List<Model_82_2> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_82_2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.ques_no.setText(model.get(position).getQues_no());
        holder.text_ques.setText(model.get(position).getText_ques());
        holder.a_1.setText(model.get(position).getA_1());
        holder.a_2.setText(model.get(position).getA_2());
        holder.a_3.setText(model.get(position).getA_3());
        holder.a_4.setText(model.get(position).getA_4());
        holder.b_1.setText(model.get(position).getB_1());
        holder.b_2.setText(model.get(position).getB_2());
        holder.b_3.setText(model.get(position).getB_3());
        holder.b_4.setText(model.get(position).getB_4());

        holder.recycler_mcq.setHasFixedSize(true);
        holder.recycler_mcq.setLayoutManager(new GridLayoutManager(context,2));
        mcq_model.add(new AllModel("1","A-1,B-2,C-3,D-4"));
        mcq_model.add(new AllModel("1","A-1,B-2,C-3,D-4"));
        mcq_model.add(new AllModel("1","A-1,B-2,C-3,D-4"));
        mcq_model.add(new AllModel("1","A-1,B-2,C-3,D-4"));
        mCqAdapter= new MCqAdapter(context,mcq_model);
        holder.recycler_mcq.setAdapter(mCqAdapter);

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ques_no,text_ques,a_1,a_2,a_3,a_4,b_1,b_2,b_3,b_4;
        RecyclerView recycler_mcq;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ques_no = itemView.findViewById(R.id.ques_no);
            text_ques = itemView.findViewById(R.id.text_ques);
            a_1 = itemView.findViewById(R.id.a_1);
            a_2 = itemView.findViewById(R.id.a_2);
            a_3 = itemView.findViewById(R.id.a_3);
            a_4 = itemView.findViewById(R.id.a_4);
            b_1 = itemView.findViewById(R.id.b_1);
            b_2 = itemView.findViewById(R.id.b_2);
            b_3 = itemView.findViewById(R.id.b_3);
            b_4 = itemView.findViewById(R.id.b_4);


            recycler_mcq = itemView.findViewById(R.id.recycler_mcq);

        }
    }

    public class MCqAdapter extends RecyclerView.Adapter<MCqAdapter.MyViewHolder> {

        Context context;
        List<AllModel> model = new ArrayList<>();
        int row_index = -1;
        public MCqAdapter(Context context, List<AllModel> model) {
            this.context = context;
            this.model = model;
        }

        @NonNull
        @Override
        public MCqAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_mcq, parent, false);
            return new MCqAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

            holder.rb1.setText(model.get(position).getText());
            if (row_index == -1) {
                holder.rb1.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(context,R.drawable.checkbox),null,null,null);
                holder.rb1.setTextColor(Color.parseColor("#3e3e3e"));

            } else {
                if (row_index == position) {
                    holder.rb1.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(context,R.drawable.checkbox_check2),null,null,null);
                    holder.rb1.setTextColor(Color.parseColor("#753abc"));


                } else {
                    holder.rb1.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(context,R.drawable.checkbox),null,null,null);
                    holder.rb1.setTextColor(Color.parseColor("#3e3e3e"));
                }
            }

            holder.rb1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.rb1.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(context,R.drawable.checkbox_check2),null,null,null);
                   // holder.rb1.setCompoundDrawablesRelative(ContextCompat.getDrawable(context,R.drawable.checkbox_check2),null,null,null);

                    if (row_index != position) {
                        notifyItemChanged(row_index);
                        row_index = position;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return model.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {


            RadioButton rb1;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                rb1 = itemView.findViewById(R.id.rb1);

            }
        }
    }

}
