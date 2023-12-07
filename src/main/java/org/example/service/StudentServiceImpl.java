package org.example.service;

import org.example.dto.StudentDto;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {
    private StudentRepo repo;
    private StudentMapper mapper;

    @Autowired
    private StudentServiceImpl(StudentRepo repo, StudentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = repo.findAll();
        return students.stream().map(mapper::mapToDto).toList();
    }

    public StudentDto getStudentById(int id) {
        Optional<Student> student = repo.findById(id);
        return student.map(value -> mapper.mapToDto(value)).orElse(null);
    }

    public void createStudent(StudentDto studentDto) {
        Student student = mapper.mapToEntity(studentDto);
        repo.saveAndFlush(student);
    }

    public void updateStudent(int id, StudentDto studentDto) {
        Optional<Student> student = repo.findById(id);
        student.ifPresent(value -> repo.save(value));
    }
}
