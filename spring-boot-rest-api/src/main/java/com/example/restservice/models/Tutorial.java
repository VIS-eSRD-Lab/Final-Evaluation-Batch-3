package com.example.restservice.models;

import org.springframework.data.annotation.Id;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "tutorial")
public class Tutorial implements Serializable{
    @javax.persistence.Id
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            initialValue = 1,
            name = "tutorial_seq",
            sequenceName = "tutorial_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tutorial_seq"
    )
    private long id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

}