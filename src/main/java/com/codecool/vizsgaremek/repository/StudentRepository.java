package com.codecool.vizsgaremek.repository;

import com.codecool.vizsgaremek.modell.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
