package com.tuteeapp.student.Model;

public class Teacher_Model {

    String text_name,board,subj_1,subj_2,subj_3,subscriber,views,videos;

    public Teacher_Model(String text_name, String board, String subj_1, String subj_2, String subj_3, String subscriber, String views, String videos) {
        this.text_name = text_name;
        this.board = board;
        this.subj_1 = subj_1;
        this.subj_2 = subj_2;
        this.subj_3 = subj_3;
        this.subscriber = subscriber;
        this.views = views;
        this.videos = videos;
    }

    public String getText_name() {
        return text_name;
    }

    public String getBoard() {
        return board;
    }

    public String getSubj_1() {
        return subj_1;
    }

    public String getSubj_2() {
        return subj_2;
    }

    public String getSubj_3() {
        return subj_3;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public String getViews() {
        return views;
    }

    public String getVideos() {
        return videos;
    }
}
