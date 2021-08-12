package com.tuteeapp.student.Model;

public class Model_Comments {

    String img_person,text_person,text_comments;

    public Model_Comments(String img_person, String text_person, String text_comments) {
        this.img_person = img_person;
        this.text_person = text_person;
        this.text_comments = text_comments;
    }

    public String getImg_person() {
        return img_person;
    }

    public String getText_person() {
        return text_person;
    }

    public String getText_comments() {
        return text_comments;
    }

}
