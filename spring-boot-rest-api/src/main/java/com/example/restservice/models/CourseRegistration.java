package com.example.restservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "i21b0001s16")
public class CourseRegistration {

    @javax.persistence.Id
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "i21b0001s16_seq",
            sequenceName = "i21b0001s16_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "i21b0001s16_seq"
    )
    private int id;

    @Column(name = "studentId")
    private int studentId;

    @Column(name = "courseId")
    private int courseId;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "courseFee")
    private float courseFee;

    @Column(name = "phase")
    private int phase;

    @Column(name = "session")
    private String session;

    @Column(name = "regStatus")
    private boolean regStatus;

    @Column(name = "paymentStatus")
    private boolean paymentStatus;

    @Column(name = "dueDate")
    private Instant dueDate;

    @Column(name = "requestDate")
    private Instant requestDate;

    @Column(name = "createdOn")
    private Instant createdOn;
}
