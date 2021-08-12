package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.QuestionModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.Myholder> {
    ArrayList<QuestionModel> arrayList;
    Context context;
    private int selectedIndex;

    public QuestionAdapter(ArrayList<QuestionModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        selectedIndex = 0;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_test_exam, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.qs.setText("Q."+arrayList.get(position).getQs()+" Which of the following is not a Rule of Language ?");
    }
    public void setSelectedIndex(int position){
        selectedIndex = position;
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        TextView qs;
        RelativeLayout rel;


        public Myholder(@NonNull View itemView) {
            super(itemView);
            qs = itemView.findViewById(R.id.qs);

        }
    }
}
