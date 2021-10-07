package com.example.restservice.models.tutorial;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "i21b0001s25")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer studentID;
    private Integer courseID;
    private String courseName;
    private Float courseFee;
    private Integer phase;
    private String session;
    private Boolean regStatus;
    private Boolean paymentStatus;
    private Date dueDate;
    private Date requestDate;
}
