package com.example.restservice.Test2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "s07_phase")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int phase;

    @OneToMany(mappedBy = "phase",cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("phase")
    private List<Course> courses=new ArrayList<>();


    @OneToMany(mappedBy = "phase",cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("phase")
    private List<Student> students=new ArrayList<>();

    public Phase() {
    }

    public Phase(int phase, List<Course> courses, List<Student> students) {
        this.phase = phase;
        this.courses = courses;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
