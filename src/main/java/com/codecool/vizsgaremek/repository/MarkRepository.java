package com.codecool.vizsgaremek.repository;

import com.codecool.vizsgaremek.modell.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Long> {
}
