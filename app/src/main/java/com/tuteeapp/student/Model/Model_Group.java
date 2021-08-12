package com.tuteeapp.student.Model;

public class Model_Group {
    int image;
    String text1,text2,type,unread;

    public int getImage() {
        return image;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getType() {
        return type;
    }

    public String getUnread() {
        return unread;
    }

    public Model_Group(int image, String text1, String text2, String type, String unread) {
        this.image = image;
        this.text1 = text1;
        this.text2 = text2;
        this.type = type;
        this.unread = unread;
    }
}
