package com.tuteeapp.student.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.tuteeapp.student.EnterDetails;
import com.tuteeapp.student.R;
import com.tuteeapp.student.RegistrationSuccessful;


public class FourthFragment extends Fragment {
    Button btncreate;
    String text;
    TextView longtext;
    ImageView imagearrow;
    ImageView imagecheckbox, imagecheckbox1;

    public FourthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enter_details4, container, false);
        btncreate = view.findViewById(R.id.btncreate);
        longtext = view.findViewById(R.id.longtext);
        imagearrow = view.findViewById(R.id.imagearrow);
        text = getString(R.string.lngtext);
        text = text.replace("Tearms &amp; Conditions", "<font color='#753abc'>Tearms &amp; Conditions</font>");
        longtext.setText(Html.fromHtml(text));

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
        //   imagecheckbox = view.findViewById(R.id.imagecheckbox);
        //  imagecheckbox1 = view.findViewById(R.id.imagecheckbox1);

        //    imagecheckbox1.setVisibility(View.GONE);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), RegistrationSuccessful.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    /*    imagecheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagecheckbox1.setVisibility(View.VISIBLE);
                imagecheckbox.setVisibility(View.GONE);
            }
        });
        imagecheckbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagecheckbox.setVisibility(View.VISIBLE);
                imagecheckbox1.setVisibility(View.GONE);
            }
        });  */
        return view;
    }

    public interface FragtoAct {
        void fragactity();
    }
}