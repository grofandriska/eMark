package com.codecool.vizsgaremek.modell.dto;

import com.codecool.vizsgaremek.modell.Class;
import com.codecool.vizsgaremek.modell.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private long id;
    private String studentName;
    private Class studentClass;
    private List<Mark> studentMarks;
}
