package com.tuteeapp.student.Model;

public class GradeModel {

    String text_grade,text_student;

    public GradeModel(String text_grade, String text_student) {
        this.text_grade = text_grade;
        this.text_student = text_student;
    }

    public String getText_grade() {
        return text_grade;
    }

    public String getText_student() {
        return text_student;
    }
}
