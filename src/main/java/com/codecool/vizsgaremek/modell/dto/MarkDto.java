package com.codecool.vizsgaremek.modell.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Long markId;
    private Integer mark;
    //Osztály-módosítható
    private String subject;
    //enum
    private String month;
    private Long studentId;
    private Long teacherId;

}
