package com.bettermind.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestDTO {
    private int id_test;
    private String question;
    private String answer;
    private Date date;
    private String level;


}
