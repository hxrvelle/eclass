package org.example.service.impl;

import org.example.entity.dto.StudentDto;
import org.example.entity.Student;
import org.example.entity.mapper.StudentMapper;
import org.example.repository.StudentRepo;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepo repo;
    private StudentMapper mapper;

    @Autowired
    public StudentServiceImpl(StudentRepo repo, StudentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = repo.findAll();
        return students.stream().map(mapper::mapToDto).toList();
    }

    @Override
    public StudentDto getStudentById(int id) {
        Optional<Student> student = repo.findWithClassesById(id);
        return mapper.mapToDto(student.get());
    }

    @Override
    public void createStudent(int id, String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        repo.save(student);
    }

    @Override
    public void updateStudent(int id, String name) {
        Optional<Student> existingStudent = repo.findById(id);
        Student student = existingStudent.get();
        student.setId(id);
        student.setName(name);
        repo.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
