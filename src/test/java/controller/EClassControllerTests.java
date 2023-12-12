package controller;

import org.example.controller.EClassController;
import org.example.entity.dto.EClassDto;
import org.example.service.EClassService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class EClassControllerTests {
    @InjectMocks
    private EClassController eClassController;
    @Mock
    private EClassService service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClasses() {
        List<EClassDto> mockClasses = new ArrayList<>();
        mockClasses.add(new EClassDto());
        mockClasses.add(new EClassDto());

        when(service.getAllClasses()).thenReturn(mockClasses);
        ResponseEntity<List<EClassDto>> responseEntity = eClassController.getClasses();

        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Response body should match expected classes", mockClasses, responseEntity.getBody());
    }

    @Test
    void testGetClassById() {
        EClassDto mockClass = new EClassDto();
        int classId = 1;

        when(service.getEClassById(classId)).thenReturn(mockClass);
        ResponseEntity<EClassDto> responseEntity = eClassController.getClassById(classId);

        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Response body should match the expected class", mockClass, responseEntity.getBody());
    }

    @Test
    void testCreateClass() {
        int studentId = 1;
        int disciplineId = 2;
        String className = "NewClass";

        doNothing().when(service).createClass(className, studentId, disciplineId);

        assertDoesNotThrow(() -> eClassController.createClass(studentId, disciplineId, className));
    }

    @Test
    void testUpdateClass() {
        int classId = 1;
        int studentId = 2;
        int disciplineId = 3;
        String updatedClassName = "UpdatedClass";

        doNothing().when(service).updateClass(classId, updatedClassName, studentId, disciplineId);

        assertDoesNotThrow(() -> eClassController.updateClass(classId, studentId, disciplineId, updatedClassName));
    }

    @Test
    void testDeleteClass() {
        int classId = 1;

        doNothing().when(service).deleteClass(classId);

        assertDoesNotThrow(() -> eClassController.deleteClass(classId));
    }
}
