package com.tuteeapp.student.Model;

public class Classroom_Model {

    String subj,time;

    public Classroom_Model(String subj, String time) {
        this.subj = subj;
        this.time = time;
    }

    public String getSubj() {
        return subj;
    }

    public String getTime() {
        return time;
    }
}
