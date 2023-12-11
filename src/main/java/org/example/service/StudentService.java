package org.example.service;

import org.example.entity.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(int id);
    void createStudent(int id, String name);
    void updateStudent(int id, String name);
    void deleteStudent(int id);
}
