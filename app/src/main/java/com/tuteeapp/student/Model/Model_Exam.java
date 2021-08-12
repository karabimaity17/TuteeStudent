package com.tuteeapp.student.Model;

public class Model_Exam {
    String text_term,text_percentile,text_date,type;

    public Model_Exam(String text_term, String text_percentile, String text_date, String type) {
        this.text_term = text_term;
        this.text_percentile = text_percentile;
        this.text_date = text_date;
        this.type = type;
    }

    public String getText_term() {
        return text_term;
    }

    public String getText_date() {
        return text_date;
    }

    public String getText_percentile() {
        return text_percentile;
    }

    public String getType() {
        return type;
    }
}
