package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    @EntityGraph(attributePaths = "classes")
    Optional<Student> findWithClassesById(int id);

    @EntityGraph(attributePaths = "classes")
    List<Student> findAll();
}