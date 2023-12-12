package controller;

import org.example.controller.StudentController;
import org.example.entity.dto.StudentDto;
import org.example.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class StudentControllerTests {
    @InjectMocks
    private StudentController studentController;
    @Mock
    private StudentService service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getStudents_Test() {
        List<StudentDto> mockStudents = new ArrayList<>();
        mockStudents.add(new StudentDto());
        mockStudents.add(new StudentDto());

        when(service.getAllStudents()).thenReturn(mockStudents);
        ResponseEntity<List<StudentDto>> responseEntity = studentController.getStudents();

        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Response body should match expected students", mockStudents, responseEntity.getBody());
    }

    @Test
    void getStudentById_Test() {
        StudentDto mockStudent = new StudentDto();
        int studentId = 1;

        when(service.getStudentById(studentId)).thenReturn(mockStudent);
        ResponseEntity<StudentDto> responseEntity = studentController.getStudentById(studentId);

        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Response body should match the expected student", mockStudent, responseEntity.getBody());
    }

    @Test
    void createStudent_Test() {
        int studentId = 1;
        String studentName = "Alice";

        doNothing().when(service).createStudent(studentId, studentName);

        assertDoesNotThrow(() -> studentController.createStudent(studentId, studentName));
    }

    @Test
    void updateStudent_Test() {
        int studentId = 1;
        String updatedName = "Bob";

        doNothing().when(service).updateStudent(studentId, updatedName);

        assertDoesNotThrow(() -> studentController.updateStudent(studentId, updatedName));
    }

    @Test
    void deleteStudent_Test() {
        int studentId = 1;

        doNothing().when(service).deleteStudent(studentId);

        assertDoesNotThrow(() -> studentController.deleteStudent(studentId));
    }
}
