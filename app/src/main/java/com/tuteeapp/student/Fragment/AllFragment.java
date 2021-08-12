package com.tuteeapp.student.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.tuteeapp.student.Model.Model_demo14;
import com.tuteeapp.student.R;

import java.util.ArrayList;


public class AllFragment extends Fragment {
    //String Number[]={"1","2","3","4","5","6"};
    // int[] array = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
    RecyclerView rv;
    ArrayList<Model_demo14> arrayList = new ArrayList();
//    Recycleadapter.RecyclerViewClickListener listener;

    public AllFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        rv = view.findViewById(R.id.rv);
        initailize();
        return view;

    }

    private void initailize() {
        setonClick();
        SubjectAdapter recycleadapter = new SubjectAdapter(arrayList);
        rv.setAdapter(recycleadapter);
        arrayList.add(new Model_demo14(R.drawable.image1,"1"));
        arrayList.add(new Model_demo14(R.drawable.image2,"2"));
        arrayList.add(new Model_demo14(R.drawable.image3,"3"));
        arrayList.add(new Model_demo14(R.drawable.image4,"4"));
        arrayList.add(new Model_demo14(R.drawable.image5,"5"));
        arrayList.add(new Model_demo14(R.drawable.image6,"6"));
    }

    private void setonClick() {
       /* listener = new Recycleadapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
             //  Intent i = new Intent(getActivity(), CustomizeSyllabus15.class);
             //  startActivity(i);
            }
        };*/
    }
    public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.Myholder> {
        ArrayList<Model_demo14> arrayList;
        Context context;

        public SubjectAdapter(ArrayList<Model_demo14> arrayList) {
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public SubjectAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.single_video, parent, false);
            SubjectAdapter.Myholder myholder = new SubjectAdapter.Myholder(view);
            return myholder;
        }

        @Override
        public void onBindViewHolder(@NonNull SubjectAdapter.Myholder holder, int position) {
            holder.imageall.setImageResource(arrayList.get(position).getImage());
            holder.lock.setVisibility(View.GONE);
            holder.number.setText(arrayList.get(position).getTextnumber());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class Myholder extends RecyclerView.ViewHolder {
            ImageView imageall,lock;
            TextView number;
            public Myholder(@NonNull View itemView) {
                super(itemView);
                imageall = itemView.findViewById(R.id.imageall);
                lock = itemView.findViewById(R.id.lock);
                number = itemView.findViewById(R.id.number);
            }
        }
    }
}