package com.tuteeapp.student.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.tuteeapp.student.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class FirstFragment extends Fragment {
    MaterialBetterSpinner spinemail, spingender, spinnation;
    String Gender[] = {"Male", "Female"};
    String Nation[] = {"Indian", "Chinese", "Nepali"};
    String Email[] = {"sona@gmail.com", "puja@Yahoo.com"};

    public FirstFragment() {

    }

    Button btnnext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_details1, container, false);
        btnnext = view.findViewById(R.id.btnnext);
        spingender = view.findViewById(R.id.spingender);
        spinnation = view.findViewById(R.id.spinnation);
        spinemail = view.findViewById(R.id.spinemail);

        ArrayAdapter<String> arrayAdaptergender = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, Gender);
        spingender.setAdapter(arrayAdaptergender);
        ArrayAdapter<String> arrayAdapternation = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, Nation);
        spinnation.setAdapter(arrayAdapternation);
        ArrayAdapter<String> arrayAdapteremail = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, Email);
        spinemail.setAdapter(arrayAdapteremail);
        return view;

    }


}