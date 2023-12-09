package org.example.service;

import org.example.dto.StudentDto;
import org.example.mapper.StudentMapper;
import org.example.repository.StudentRepo;

import java.sql.Date;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(int id);
    void createStudent(String surname, String name, String group, Date date);
    void updateStudent(int id, String surname, String name, String group, Date date);
    void deleteStudent(int id);
}
