package com.example.restservice.Test1;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String dob;
    private String phone;
    private String email;
    private String batch;
    private int prePhase;
    private int currentPhase;

    private List<Course> courses=new ArrayList<>();

    public Student() {
    }

    public Student(int id, String name, String dob, String phone, String email, String batch, int prePhase, int currentPhase, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.batch = batch;
        this.prePhase = prePhase;
        this.currentPhase = currentPhase;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getPrePhase() {
        return prePhase;
    }

    public void setPrePhase(int prePhase) {
        this.prePhase = prePhase;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }
}
