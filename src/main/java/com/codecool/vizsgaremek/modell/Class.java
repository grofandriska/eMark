package com.codecool.vizsgaremek.modell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   /* @OneToOne(mappedBy = "classIdTeacher")
    @JsonIgnore
    private Teacher teacher;
    @OneToMany(mappedBy = "classID")
    @JsonIgnore
    private List<Student> students ;*/

}
