package org.example.controller;

import org.example.dto.StudentDto;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentServiceImpl service;

    @Autowired
    private StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllStudents() {
        List<StudentDto> studentDtos = service.getAllStudents();
        if (studentDtos.isEmpty()) return ResponseEntity.status(HttpStatus.OK).body("There are no students");
        return ResponseEntity.status(HttpStatus.OK).body(studentDtos);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity getStudentById(@PathVariable int id) {
        StudentDto student = service.getStudentById(id);
        if (student == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student with this ID doesn't exist");
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentDto student) {
        service.createStudent(student);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateStudent(@PathVariable int id, @RequestBody StudentDto student) {
        service.updateStudent(id, student);
    }

}
