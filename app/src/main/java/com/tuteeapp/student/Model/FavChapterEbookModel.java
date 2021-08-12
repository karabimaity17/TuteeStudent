package com.tuteeapp.student.Model;

public class FavChapterEbookModel {

    String subject,chapter,views;

    public FavChapterEbookModel(String subject) {
        this.subject = subject;
    }
    /* public FavChapterEbookModel(String subject, String chapter, String views) {
        this.subject = subject;
        this.chapter = chapter;
        this.views = views;
    }*/

    public String getSubject() {
        return subject;
    }

    public String getChapter() {
        return chapter;
    }

    public String getViews() {
        return views;
    }
}
