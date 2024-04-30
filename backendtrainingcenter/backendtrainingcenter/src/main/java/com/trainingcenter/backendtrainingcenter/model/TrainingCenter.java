package com.trainingcenter.backendtrainingcenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainingcenters")
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "CenterName")
    private String centerName;


    @Column(name = "CenterCode")
    private String centerCode;

    @Embedded
    private Address address;

    @Column(name = "StudentCapacity")
    private int studentCapacity;

    @Column(name = "CoursesOffered")
    private List<String> coursesOffered;

    @Column(name = "CreatedOn")
    private String createdOn;

    @Column(name = "ContactEmail")
    private String contactEmail;

    @Column(name = "ContactPhone")
    private String contactPhone;

}
