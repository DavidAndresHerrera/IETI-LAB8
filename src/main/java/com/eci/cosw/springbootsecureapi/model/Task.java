package com.eci.cosw.springbootsecureapi.model;

import java.util.Date;

public class Task {
    private Integer id;
    private String responsible, text, status;
    private Date dueDate;

    public Task(Integer id, String text, String responsible, String status, Date dueDate )
    {
        this.id=id;
        this.text = text;
        this.responsible = responsible;
        this.status = status;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
