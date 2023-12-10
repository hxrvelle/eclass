package org.example.repository;

import org.example.entity.EClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EClassRepo extends JpaRepository<EClass, Integer> {}