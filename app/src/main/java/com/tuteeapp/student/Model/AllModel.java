package com.tuteeapp.student.Model;

public class AllModel {
    int image;
    String number;
    String id,text;

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public AllModel(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getNumber() {
        return number;
    }


    public AllModel(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public AllModel(int image) {
        this.image = image;
    }
}
