package com.tuteeapp.student.Model;

public class LessonPlanModel {
    int image;
    String textnumber;

    public int getImage() {
        return image;
    }

    public String getTextnumber() {
        return textnumber;
    }

    public LessonPlanModel(int image, String textnumber) {
        this.image = image;
        this.textnumber = textnumber;
    }
}
