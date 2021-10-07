package com.example.restservice.Test2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "s07_course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_fee")
    private int course_fee;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties({"courses"})
    private List<Student> students=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn( foreignKey = @ForeignKey(name = "phase_id"), name = "phase_id")
    @JsonIgnoreProperties("courses")
    private Phase phase;

    public Course() {
    }

    public Course(int courseId, String name, int course_fee, List<Student> students, Phase phase) {
        this.courseId = courseId;
        this.name = name;
        this.course_fee = course_fee;
        this.students = students;
        this.phase = phase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(int course_fee) {
        this.course_fee = course_fee;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }
}
