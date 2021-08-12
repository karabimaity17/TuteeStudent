package com.tuteeapp.student.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.tuteeapp.student.R;


public class Assignment_Fragment_4 extends Fragment {

    CardView card_img;
    ImageView img_cancel,img_active_upload;
    LinearLayout linear_uploading;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assignment_4,container,false);

        img_active_upload = view.findViewById(R.id.img_active_upload);
        img_cancel = view.findViewById(R.id.img_cancel);
        card_img = view.findViewById(R.id.card_img);
        linear_uploading = view.findViewById(R.id.linear_uploading);

        card_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                card_img.setVisibility(View.GONE);
                img_active_upload.setVisibility(View.VISIBLE);
                linear_uploading.setVisibility(View.VISIBLE);
            }
        });
        img_cancel.setOnClickListener(new View.OnClickListener() {
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
