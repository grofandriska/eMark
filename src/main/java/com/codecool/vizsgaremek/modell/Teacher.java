package com.codecool.vizsgaremek.modell;

import javax.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String subject;
    @OneToOne(mappedBy = "teacher")
    private Class headmasterClass;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Class getHeadmasterClass() {
        return headmasterClass;
    }

    public void setHeadmasterClass(Class headmasterClass) {
        this.headmasterClass = headmasterClass;
    }
}
