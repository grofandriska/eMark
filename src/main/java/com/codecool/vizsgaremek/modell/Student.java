package com.codecool.vizsgaremek.modell;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "the name of the student", example = "Kerekes Péter")
    private String studentName;
    @Schema(description = "the gender of the student", example = "Male")
    private String gender;
    @ManyToOne
    @Schema(description = "the id of the student's class", example = "2")
    private Class classID;

}
