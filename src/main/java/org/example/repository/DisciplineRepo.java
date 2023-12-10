package org.example.repository;

import org.example.entity.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepo extends JpaRepository<Discipline, Integer> {
}
