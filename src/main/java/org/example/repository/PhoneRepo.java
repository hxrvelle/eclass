package org.example.repository;

import org.example.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Integer> {
}
