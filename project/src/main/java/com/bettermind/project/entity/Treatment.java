package com.bettermind.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_treatment;
    private String type;
    private Date date;
    private int hours;
}
