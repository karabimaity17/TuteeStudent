package com.tuteeapp.student.Model;

import java.util.List;

public class ExerciseReportModel {
    String text;
    List<OptionModel> modelList;

    public String getText() {
        return text;
    }

    public List<OptionModel> getModelList() {
        return modelList;
    }

    public ExerciseReportModel(String text, List<OptionModel> modelList) {
        this.text = text;
        this.modelList = modelList;
    }
}
