package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.tuteeapp.student.EnterDetails;
import com.tuteeapp.student.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class SecondFragment extends Fragment {
    ImageView imagearrow;
    MaterialBetterSpinner spingrade, spinschool, spinstate;
    String Grade[] = {"9-12", "15-20"};
    String School[] = {"Abu Dhabi School", "kolkata High School"};
    String State[] = {"West Bengal", "Bihar"};

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_details2, container, false);
        spingrade = view.findViewById(R.id.spingrade);
        spinschool = view.findViewById(R.id.spinschool);
        spinstate = view.findViewById(R.id.spinstate);
        imagearrow = view.findViewById(R.id.imagearrow);

        imagearrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EnterDetails)getActivity()).updateApi(new SecondFragment.FragtoAct() {
                    @Override
                    public void fragactity() {

                    }
                });


            }
        });
        ArrayAdapter<String> arrayAdaptergender = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, Grade);
        spingrade.setAdapter(arrayAdaptergender);
        ArrayAdapter<String> arrayAdapternation = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, School);
        spinschool.setAdapter(arrayAdapternation);
        ArrayAdapter<String> arrayAdapteremail = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, State);
        spinstate.setAdapter(arrayAdapteremail);
        return view;
    }
    public  interface FragtoAct{
        void fragactity();
    }
}