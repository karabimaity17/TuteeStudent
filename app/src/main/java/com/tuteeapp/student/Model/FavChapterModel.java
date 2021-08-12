package com.tuteeapp.student.Model;

public class FavChapterModel {

    String chapter_title,day,desc,view,subj,lesson_code;

    public FavChapterModel(String chapter_title, String day, String desc, String view, String subj, String lesson_code) {
        this.chapter_title = chapter_title;
        this.day = day;
        this.desc = desc;
        this.view = view;
        this.subj = subj;
        this.lesson_code = lesson_code;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public String getDay() {
        return day;
    }

    public String getDesc() {
        return desc;
    }

    public String getView() {
        return view;
    }

    public String getSubj() {
        return subj;
    }

    public String getLesson_code() {
        return lesson_code;
    }

}
