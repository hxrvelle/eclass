package controller;

import org.example.controller.DisciplineController;
import org.example.entity.dto.DisciplineDto;
import org.example.service.DisciplineService;
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

public class DisciplineControllerTests {
    @InjectMocks
    private DisciplineController disciplineController;
    @Mock
    private DisciplineService service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDisciplines() {
        List<DisciplineDto> mockDisciplines = new ArrayList<>();
        mockDisciplines.add(new DisciplineDto());
        mockDisciplines.add(new DisciplineDto());

        when(service.getAllDisciplines()).thenReturn(mockDisciplines);
        ResponseEntity<List<DisciplineDto>> responseEntity = disciplineController.getDisciplines();

        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Response body should match expected disciplines", mockDisciplines, responseEntity.getBody());
    }

    @Test
    void testGetDisciplineById() {
        DisciplineDto mockDiscipline = new DisciplineDto(1, "Math");
        int disciplineId = 1;

        when(service.getDisciplineById(disciplineId)).thenReturn(mockDiscipline);
        ResponseEntity<DisciplineDto> responseEntity = disciplineController.getDisciplineById(disciplineId);

        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Response body should match the expected discipline", mockDiscipline, responseEntity.getBody());
    }

    @Test
    void testCreateDiscipline() {
        String disciplineName = "English";

        doNothing().when(service).createDiscipline(disciplineName);

        assertDoesNotThrow(() -> disciplineController.createDiscipline(disciplineName));
    }

    @Test
    void testUpdateDiscipline() {
        int disciplineId = 1;
        String updatedDisciplineName = "Physics";

        doNothing().when(service).updateDiscipline(disciplineId, updatedDisciplineName);

        assertDoesNotThrow(() -> disciplineController.updateDiscipline(disciplineId, updatedDisciplineName));
    }

    @Test
    void testDeleteDiscipline() {
        int disciplineId = 1;

        doNothing().when(service).deleteDiscipline(disciplineId);

        assertDoesNotThrow(() -> disciplineController.deleteDiscipline(disciplineId));
    }
}
