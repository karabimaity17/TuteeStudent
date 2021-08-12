package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.tuteeapp.student.EnterDetails;
import com.tuteeapp.student.R;


public class ThirdFragment extends Fragment {
    Button btncreate;
    String text;
    TextView longtext;
    ImageView imagearrow;
    ImageView imagecheckbox, imagecheckbox1;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_details3, container, false);

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

        return view;
    }

    public interface FragtoAct {
        void fragactity();
    }
}