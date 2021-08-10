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
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "the value of the mark", example = "5")
    private double mark;
    @Schema(description = "the name of the subject", example = "JAVA")
    private String subject;
    @Schema(description = "the name of the month when mark was given", example = "April")
    private String month;
    @OneToOne
    @Schema(description = "the id of the student of the mark", example = "2")
    private Student student;
    @OneToOne
    @Schema(description = "the id of the teacher of the mark", example = "1")
    private Teacher teacher;
}
