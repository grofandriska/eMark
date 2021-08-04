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
   /* @Transient
    @OneToOne(mappedBy = "classIdTeacher")
    private Teacher teacher;*/
   /* @Transient
    @OneToMany(mappedBy = "classID")
    private List<Student> students ;*/

}
