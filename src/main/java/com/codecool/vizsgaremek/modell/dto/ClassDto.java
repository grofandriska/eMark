package com.codecool.vizsgaremek.modell.dto;

import com.codecool.vizsgaremek.modell.Student;
import com.codecool.vizsgaremek.modell.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClassDto {

    private long id;
    private String name;
    private List<Student> students;
    private Teacher headMaster;
    private int size;
}
