package com.codecool.vizsgaremek.modell;

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
    private String studentName;
    @ManyToOne/*(cascade = CascadeType.ALL)*/
    private Class classID;

}
