package com.tuteeapp.student.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tuteeapp.student.Model.AllModel;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.Myholder> {
    Context context;
    ArrayList<AllModel> arrayList;
    private callback listener;
    private View selectView;
    private int selectedIndex;

    public PageAdapter(Context context, ArrayList<AllModel> arrayList, callback listener) {
        this.context = context;
        this.arrayList = arrayList;
        this.listener = listener;
        selectedIndex = 0;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.selected_page, parent, false);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholder holder, final int position) {
       holder.number.setText(arrayList.get(position).getNumber());
        if(selectedIndex == position){
            holder.number.setBackgroundResource(R.drawable.background3);
            holder.number.setTextColor(Color.WHITE);
            selectedIndex = position;
            selectView = holder.number;
        }else {
            holder.number.setBackgroundColor(Color.WHITE);
            holder.number.setTextColor(Color.BLACK);

        }

        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.number.setBackgroundResource(R.drawable.background3);
                holder.number.setTextColor(Color.WHITE);
                if(selectedIndex != position){
                    selectView.setBackgroundColor(Color.WHITE);
                    holder.number.setTextColor(Color.BLACK);
                }
                selectView = holder.number;
                selectedIndex = position;
                listener.onTitleClicked(position);
            }
        });
    }
    public void setSelectedIndex(int position){
        selectedIndex = position;
    }

    public interface callback{
        void onTitleClicked(int position);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView number;


        public Myholder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.number);
        }

    }
}
