package com.tuteeapp.student.Model;

public class Model_Notification {

    int image;
    String text_name,board,desc;


    public Model_Notification(int image, String text_name, String board, String desc) {
        this.image = image;
        this.text_name = text_name;
        this.board = board;
        this.desc = desc;
    }

    public Model_Notification(String text_name, String board, String desc) {
        this.text_name = text_name;
        this.board = board;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getText_name() {
        return text_name;
    }

    public String getBoard() {
        return board;
    }

    public String getDesc() {
        return desc;
    }

}
