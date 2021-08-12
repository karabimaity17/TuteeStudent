package com.tuteeapp.student.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.tuteeapp.student.R;

import java.util.ArrayList;

public class Exercise_ReportFragment extends Fragment {

    PieChart piechart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_exercise_report,container,false);

        piechart = view.findViewById(R.id.piechart);

        piechart.setUsePercentValues(false);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,5);

        piechart.setDrawHoleEnabled(true);
        piechart.setCenterText("50% \nOverall");
        piechart.setCenterTextColor(ContextCompat.getColor(getActivity(),R.color.colorPurple));
        piechart.setEntryLabelColor(Color.BLACK);
        piechart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(25f,"Chemistry"));
        yValues.add(new PieEntry(50f,"English"));
        yValues.add(new PieEntry(30f,"Maths"));
        yValues.add(new PieEntry(25f,"Physics"));


        piechart.animateY(1000, Easing.EaseInOutCubic);

        PieDataSet dataSet = new PieDataSet(yValues,"(Overall)");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        final int[] MY_COLORS = {ContextCompat.getColor(getActivity(),R.color.light_blue), ContextCompat.getColor(getActivity(),R.color.yellow2),
                ContextCompat.getColor(getActivity(),R.color.teal_200), ContextCompat.getColor(getActivity(),R.color.colorPurple)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int c: MY_COLORS) colors.add(c);

        dataSet.setColors(colors);

       // dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        piechart.setData(data);


        return view;
    }
}
