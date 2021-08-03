package com.codecool.vizsgaremek.repository;

import com.codecool.vizsgaremek.modell.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
