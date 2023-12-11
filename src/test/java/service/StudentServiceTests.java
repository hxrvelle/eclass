package service;

import org.example.entity.Student;
import org.example.entity.dto.StudentDto;
import org.example.entity.mapper.StudentMapper;
import org.example.repository.StudentRepo;
import org.example.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class StudentServiceTests {
    @InjectMocks
    private StudentServiceImpl service;
    @Mock
    private StudentRepo repo;
    @Mock
    private StudentMapper mapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllStudents_Test() {
        when(repo.findAll()).thenReturn(new ArrayList<>());
        List<StudentDto> result = service.getAllStudents();

        verify(repo, atLeastOnce()).findAll();
        assertNotNull(result);
    }

    @Test
    void getStudentById_Test() {
        int studentId = 1;
        Student mockStudent = new Student();
        when(repo.findWithClassesById(studentId)).thenReturn(Optional.of(mockStudent));

        StudentDto mockStudentDto = new StudentDto();
        when(mapper.mapToDto(any(Student.class))).thenReturn(mockStudentDto);

        StudentDto result = service.getStudentById(studentId);

        verify(repo, times(1)).findWithClassesById(studentId);
        assertNotNull(result);
    }

    @Test
    void createStudent_Test() {
        int studentId = 1;
        String studentName = "John Doe";

        service.createStudent(studentId, studentName);

        verify(repo, times(1)).save(argThat(student -> student.getId() == studentId && student.getName().equals(studentName)));
    }

    @Test
    void updateStudent_Test() {
        int studentId = 1;
        String updatedName = "Updated Name";
        Student existingStudent = new Student();
        existingStudent.setId(studentId);
        existingStudent.setName("Initial Name");

        when(repo.findById(studentId)).thenReturn(Optional.of(existingStudent));
        service.updateStudent(studentId, updatedName);

        verify(repo, times(1)).save(argThat(student -> student.getId() == studentId && student.getName().equals(updatedName)));
    }

    @Test
    void deleteStudent_Test() {
        int studentId = 1;
        service.deleteStudent(studentId);

        verify(repo, times(1)).deleteById(studentId);
    }
}
