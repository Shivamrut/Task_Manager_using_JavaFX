package com.example.task_manager;

public class Task {
    private String title;
    private boolean status;
    private int id;

    public Task(String title, boolean status,int id) {
        this.title = title;
        this.status = status;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id+" " +title + " - { status : " + (status?" Completed":" Pending") + " }";
    }
}
