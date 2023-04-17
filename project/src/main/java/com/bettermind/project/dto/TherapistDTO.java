package com.bettermind.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TherapistDTO {
    private int idTherapist;
    private String name;
    private String position;
    private String gender;
    private int mobile;
    private String email;
    private String description;
    private String location;
}
