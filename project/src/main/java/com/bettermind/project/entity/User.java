package com.bettermind.project.entity;
import java.util.Date;
//import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private String gender;
    private int mobile;
    private String email;
    private String password;
    private String emergencyContactName;
    private int emergencyContactNumber;

    //@ManyToOne
    //@JoinColumn(name="idTherapist", nullable=false)
    //private Therapist therapist;
}

