package com.tuteeapp.student.Model;

import java.util.List;

public class MonthModel {

    String month;
    List<ChapterLibraryModel> chapterLibraryModels;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<ChapterLibraryModel> getChapterLibraryModels() {
        return chapterLibraryModels;
    }

    public void setChapterLibraryModels(List<ChapterLibraryModel> chapterLibraryModels) {
        this.chapterLibraryModels = chapterLibraryModels;
    }

    public MonthModel(String month, List<ChapterLibraryModel> chapterLibraryModels) {
        this.month = month;
        this.chapterLibraryModels = chapterLibraryModels;
    }
}
