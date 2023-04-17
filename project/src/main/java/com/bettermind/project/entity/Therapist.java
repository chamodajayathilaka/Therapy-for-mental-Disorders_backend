package com.bettermind.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Therapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTherapist;
    private String name;
    private String position;
    private String gender;
    private int mobile;
    private String email;
    private String discription;
    private String address;

    //@OneToMany(mappedBy = "therapist")
    //private Set<User> users;

}
