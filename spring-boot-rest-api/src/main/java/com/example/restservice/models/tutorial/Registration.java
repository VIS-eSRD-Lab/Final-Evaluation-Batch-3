package com.example.restservice.models.tutorial;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "i21b0001s14")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "studentID")
    private String studentID;
    @Column(name = "courseID")
    private String courseID;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "courseFee")
    private String courseFee;
    @Column(name = "phase")
    private String phase;
    @Column(name = "session")
    private String session;
    @Column(name = "regStatus")
    private Boolean regStatus;
    @Column(name = "paymentStatus")
    private Boolean paymentStatus;
    @Column(name = "dueDate")
    private String dueDate;
    @Column(name = "requestDate")
    private String requestDate;


}
