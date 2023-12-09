package org.example.controller;

import org.example.dto.StudentDto;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentServiceImpl service;

    @Autowired
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtos = service.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(studentDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id) {
        StudentDto student = service.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(
            @RequestParam String surname,
            @RequestParam String name,
            @RequestParam String group,
            @RequestParam Date date
            ) {
        service.createStudent(surname, name, group, date);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(
            @PathVariable int id,
            @RequestParam String surname,
            @RequestParam String name,
            @RequestParam String group,
            @RequestParam Date date
    ) {
        service.updateStudent(id, surname, name, group, date);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}