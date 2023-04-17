package com.bettermind.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreatmentDTO {
    private int id_treatment;
    private String type;
    private Date date;
    private int hours;

}
