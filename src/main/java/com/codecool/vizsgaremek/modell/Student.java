package com.codecool.vizsgaremek.modell;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Class studentClass;

    public Student(Long id, String studentName, Class studentClass) {
        this.id = id;
        this.studentName = studentName;
        this.studentClass = studentClass;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Class getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }
}
