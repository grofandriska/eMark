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

    private long id;
    private int mark;
    private String subject;
    private String month;
    private long studentId;
    private long teacherId;
}
