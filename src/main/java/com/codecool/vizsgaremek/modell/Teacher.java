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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "the name of the teacher", example = "Szigorú Ferenc")
    private String name;
    @Schema(description = "the name of the teacher's subject", example = "SQL")
    private String subject;
    @Schema(description = "the gender of the teacher", example = "Male")
    private String gender;
}
