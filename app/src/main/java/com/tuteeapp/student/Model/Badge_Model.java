package com.tuteeapp.student.Model;

public class Badge_Model {

    int Image;
    String Text;

    public Badge_Model(int image, String text) {
        Image = image;
        Text = text;
    }

    public int getImage() {
        return Image;
    }

    public String getText() {
        return Text;
    }
}
