package com.tuteeapp.student.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tuteeapp.student.R;

public class Assignment_Fragment_1 extends Fragment {
    Button cancel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_assignment_1,container,false);
        cancel = view.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                final View dialogView = inflater.inflate(R.layout.dialog_cancel, null);
                final TextView btn_cancel = dialogView.findViewById(R.id.btn_cancel);
                final TextView btn_dont = dialogView.findViewById(R.id.btn_dont);
                builder.setView(dialogView);
                final AlertDialog alert = builder.create();
                alert.setCanceledOnTouchOutside(true);
                alert.show();
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();

                    }
                });
                btn_dont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alert.dismiss();

                    }
                });
            }
        });
        return view;
    }




}
