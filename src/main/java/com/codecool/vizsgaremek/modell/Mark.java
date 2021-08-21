package com.codecool.vizsgaremek.modell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double mark;
    @NotBlank(message = "Subject name is mandatory")
    private String subject;
    @NotBlank(message = "Month name is mandatory")
    private String month;
    @OneToOne
    private Student student;
    @OneToOne
    private Teacher teacher;
}
