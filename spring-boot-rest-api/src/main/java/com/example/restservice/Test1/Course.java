package com.example.restservice.Test1;

public class Course {
    private int id;
    private String name;
    private int phase;
    private int fee;

    public Course() {
    }

    public Course(int id, String name, int phase, int fee) {
        this.id = id;
        this.name = name;
        this.phase = phase;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
