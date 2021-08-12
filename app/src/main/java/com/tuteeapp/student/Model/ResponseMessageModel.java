package com.tuteeapp.student.Model;

public class ResponseMessageModel {
    String message;
    String my_id,date,time,msg_type;
    boolean showCheckbox;

    public ResponseMessageModel(String message, String my_id, String date, String time) {
        this.message = message;
        this.my_id = my_id;
        this.date = date;
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public ResponseMessageModel(String message, String my_id, String date, String time, String msg_type, boolean showCheckbox) {
        this.message = message;
        this.my_id = my_id;
        this.date = date;
        this.time = time;
        this.msg_type = msg_type;
        this.showCheckbox = showCheckbox;
    }

    public boolean isShowCheckbox() {
        return showCheckbox;
    }


    public void setShowCheckbox(boolean showCheckbox) {
        this.showCheckbox = showCheckbox;
    }

    public ResponseMessageModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMy_id() {
        return my_id;
    }

    public void setMy_id(String my_id) {
        this.my_id = my_id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
