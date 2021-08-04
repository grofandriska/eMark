package com.codecool.vizsgaremek.modell.dto;


import com.codecool.vizsgaremek.modell.Class;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Long id;
    private String name;
    private String subject;
    private Class classId;

}
