package com.tuteeapp.student.Model;

public class ChapterLibraryModel {

    String title,subject,lesson_code,date,views,type;

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getLesson_code() {
        return lesson_code;
    }

    public String getDate() {
        return date;
    }

    public String getViews() {
        return views;
    }

    public String getType() {
        return type;
    }

    public ChapterLibraryModel(String title, String subject, String lesson_code, String date, String views, String type) {
        this.title = title;
        this.subject = subject;
        this.lesson_code = lesson_code;
        this.date = date;
        this.views = views;
        this.type = type;
    }
}
