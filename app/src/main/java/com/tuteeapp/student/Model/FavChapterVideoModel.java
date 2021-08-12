package com.tuteeapp.student.Model;

public class FavChapterVideoModel {

    String /*img,*/views,chapter,subject;
    int img;


    /*public FavChapterVideoModel(String img, String views, String chapter, String subject) {
        this.img = img;
        this.views = views;
        this.chapter = chapter;
        this.subject = subject;
    }*/

    public FavChapterVideoModel(int img, String subject) {
        this.img = img;
        this.subject = subject;
    }

//    public String getImg() {
//        return img;
//    }


    public int getImg() {
        return img;
    }

    public String getViews() {
        return views;
    }

    public String getChapter() {
        return chapter;
    }

    public String getSubject() {
        return subject;
    }
}
