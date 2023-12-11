package service;

import org.example.entity.Discipline;
import org.example.entity.dto.DisciplineDto;
import org.example.entity.mapper.DisciplineMapper;
import org.example.repository.DisciplineRepo;
import org.example.service.impl.DisciplineServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DisciplineServiceTests {
    @InjectMocks
    private DisciplineServiceImpl service;
    @Mock
    private DisciplineRepo repo;
    @Mock
    private DisciplineMapper mapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllDisciplines_Test() {
        List<Discipline> mockDisciplines = Arrays.asList(new Discipline(), new Discipline());
        when(repo.findAll()).thenReturn(mockDisciplines);

        List<DisciplineDto> mockDisciplineDtos = Arrays.asList(new DisciplineDto(), new DisciplineDto());
        when(mapper.mapToDto(any(Discipline.class))).thenReturn(mockDisciplineDtos.get(0), mockDisciplineDtos.get(1));

        List<DisciplineDto> result = service.getAllDisciplines();

        verify(repo, times(1)).findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getDisciplineById_Test() {
        int disciplineId = 1;
        Discipline mockDiscipline = new Discipline();
        when(repo.findById(disciplineId)).thenReturn(Optional.of(mockDiscipline));

        DisciplineDto mockDisciplineDto = new DisciplineDto();
        when(mapper.mapToDto(any(Discipline.class))).thenReturn(mockDisciplineDto);

        DisciplineDto result = service.getDisciplineById(disciplineId);

        verify(repo, times(1)).findById(disciplineId);
        verify(mapper, times(1)).mapToDto(mockDiscipline);
        assertNotNull(result);
    }

    @Test
    void createDiscipline_Test() {
        String disciplineName = "Math";

        service.createDiscipline(disciplineName);

        verify(repo, times(1)).save(argThat(discipline -> discipline.getName().equals(disciplineName)));
    }

    @Test
    void updateDiscipline_Test() {
        int disciplineId = 1;
        String updatedDisciplineName = "UpdatedMath";
        Discipline existingDiscipline = new Discipline();
        existingDiscipline.setId(disciplineId);

        when(repo.findById(disciplineId)).thenReturn(Optional.of(existingDiscipline));
        service.updateDiscipline(disciplineId, updatedDisciplineName);

        verify(repo, times(1)).save(argThat(updatedDiscipline -> updatedDiscipline.getId() == disciplineId &&
                updatedDiscipline.getName().equals(updatedDisciplineName)));
    }

    @Test
    void deleteDiscipline_Test() {
        int disciplineId = 1;

        service.deleteDiscipline(disciplineId);

        verify(repo, times(1)).deleteById(disciplineId);
    }
}
