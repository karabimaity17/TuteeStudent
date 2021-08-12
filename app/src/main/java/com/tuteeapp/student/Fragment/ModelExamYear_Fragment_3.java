package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.tuteeapp.student.Adapter.Adapter_82_2;
import com.tuteeapp.student.ExamSubmit;
import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;
import java.util.List;

public class ModelExamYear_Fragment_3 extends Fragment {
    List<AllModel> mcq_model = new ArrayList<>();
     MCqAdapter mCqAdapter;
    RecyclerView recycler_mcq;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_model_exam_year3,container,false);
        recycler_mcq = view.findViewById(R.id.recycler_mcq);
        recycler_mcq.setHasFixedSize(true);
         recycler_mcq.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mcq_model.add(new AllModel("1","A"));
        mcq_model.add(new AllModel("1","B"));
        mcq_model.add(new AllModel("1","C"));
        mcq_model.add(new AllModel("1","D"));
        mCqAdapter= new  MCqAdapter(getActivity(),mcq_model);
         recycler_mcq.setAdapter(mCqAdapter);
        return view;
    }
    public class MCqAdapter extends RecyclerView.Adapter< MCqAdapter.MyViewHolder> {

        Context context;
        List<AllModel> model = new ArrayList<>();
        int row_index = -1;
        public MCqAdapter(Context context, List<AllModel> model) {
            this.context = context;
            this.model = model;
        }

        @NonNull
        @Override
        public  MCqAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.single_mcq, parent, false);
            return new  MCqAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final MCqAdapter.MyViewHolder holder, final int position) {

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
