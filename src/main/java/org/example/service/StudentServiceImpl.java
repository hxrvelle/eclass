package org.example.service;

import org.example.dto.StudentDto;
import org.example.entity.Student;
import org.example.mapper.StudentMapper;
import org.example.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
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
        List<Student> students = repo.findStudentsWithPhoneNumbers();
        return students.stream().map(mapper::mapToDto).toList();
    }

    public StudentDto getStudentById(int id) {
        Student student = repo.findStudentWithPhoneNumbers(id);
        return mapper.mapToDto(student);
    }

    @Transactional
    public void createStudent(String surname, String name, String group, Date date) {
        Student student = new Student();
        student.setSurname(surname);
        student.setName(name);
        student.setGroup(group);
        student.setDate(date);
        student.setStatus(1);

        repo.save(student);
    }

    @Transactional
    public void updateStudent(int id, String surname, String name, String group, Date date) {
        Optional<Student> existingStudent = repo.findById(id);

        Student student = existingStudent.get();
        student.setSurname(surname);
        student.setName(name);
        student.setGroup(group);
        student.setDate(date);
        student.setStatus(1);

        repo.save(student);
    }

    @Transactional
    public void deleteStudent(int id) {
        repo.deleteById(id);
    }
}
