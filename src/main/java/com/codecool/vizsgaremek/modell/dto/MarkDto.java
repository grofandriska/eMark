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
    private double mark;
    private String subject;
    private String month;
    private Long studentId;
    private Long teacherId;

}
