package com.bettermind.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
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
}
