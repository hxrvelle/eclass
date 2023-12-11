package org.example.repository;

import org.example.entity.EClass;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EClassRepo extends JpaRepository<EClass, Integer> {
    @EntityGraph(attributePaths = {"student", "student.classes", "disciplines", "student.classes.disciplines"})
    Optional<EClass> findWithStudentAndDisciplinesById(int id);

    @EntityGraph(attributePaths = {"student", "student.classes", "disciplines", "student.classes.disciplines"})
    List<EClass> findAll();
}