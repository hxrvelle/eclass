package org.example.repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.phoneNumbers WHERE s.id = :studentId")
    Student findStudentWithPhoneNumbers(@Param("studentId") int studentId);

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.phoneNumbers p WHERE s.status = 1")
    List<Student> findStudentsWithPhoneNumbers();
}
