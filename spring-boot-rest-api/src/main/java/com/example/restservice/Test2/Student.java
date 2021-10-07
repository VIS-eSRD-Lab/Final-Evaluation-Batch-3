package com.example.restservice.Test2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "s07_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private int std_id;

    @Column(name = "std_name")
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn( foreignKey = @ForeignKey(name = "id"), name = "phase_id")
    @JsonIgnoreProperties({"courses","students"})
    private Phase phase;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "s07_student_course",
            joinColumns = {
                    @JoinColumn(name = "std_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id")
            }
    )
    @JsonIgnoreProperties({"students","phase"})
    private List<Course> courses= new ArrayList<>();


    @Column(name = "reg_status")
    private boolean registrationStatus;


    @Column(name = "pay_status")
    private boolean paymentStatus;


    @Transient
    private int payableFee=0;

    private String dueDate;

    private String requestDate;

    public Student() {
    }

    public Student(int std_id, String name, Phase phase, List<Course> courses, boolean registrationStatus, boolean paymentStatus, String dueDate, String requestDate) {
        this.std_id = std_id;
        this.name = name;
        this.phase = phase;
        this.courses = courses;
        this.registrationStatus = registrationStatus;
        this.paymentStatus = paymentStatus;
        this.dueDate = dueDate;
        this.requestDate = requestDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public int getPayableFee() {
        return payableFee;
    }

    public void setPayableFee(int payableFee) {
        this.payableFee = payableFee;
    }
}
