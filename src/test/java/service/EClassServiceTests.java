package service;

import org.example.entity.Discipline;
import org.example.entity.EClass;
import org.example.entity.Student;
import org.example.entity.dto.EClassDto;
import org.example.entity.mapper.EClassMapper;
import org.example.repository.DisciplineRepo;
import org.example.repository.EClassRepo;
import org.example.repository.StudentRepo;
import org.example.service.impl.EClassServiceImpl;
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

public class EClassServiceTests {
    @InjectMocks
    private EClassServiceImpl service;
    @Mock
    private EClassRepo repo;
    @Mock
    private StudentRepo studentRepo;
    @Mock
    private DisciplineRepo disciplineRepo;
    @Mock
    private EClassMapper mapper;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllClasses_Test() {
        // Mocking behavior for repository
        List<EClass> mockEClasses = Arrays.asList(new EClass(), new EClass()); // Sample EClass objects
        when(repo.findAll()).thenReturn(mockEClasses);

        List<EClassDto> mockEClassDtos = Arrays.asList(new EClassDto(), new EClassDto()); // Sample EClassDto objects
        when(mapper.mapToDto(any(EClass.class))).thenReturn(mockEClassDtos.get(0), mockEClassDtos.get(1));

        List<EClassDto> result = service.getAllClasses();

        verify(repo, times(1)).findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void getEClassById_Test() {
        int eClassId = 1;
        EClass mockEClass = new EClass();
        when(repo.findWithStudentAndDisciplinesById(eClassId)).thenReturn(Optional.of(mockEClass));

        EClassDto mockEClassDto = new EClassDto();

        when(mapper.mapToDto(any(EClass.class))).thenReturn(mockEClassDto);
        EClassDto result = service.getEClassById(eClassId);

        verify(repo, times(1)).findWithStudentAndDisciplinesById(eClassId);
        verify(mapper, times(1)).mapToDto(mockEClass);
        assertNotNull(result);
    }

    @Test
    void createClass_Test() {
        String className = "ClassName";
        int studentId = 1;
        int disciplineId = 1;
        Student mockStudent = new Student();
        Discipline mockDiscipline = new Discipline();
        EClass mockEClass = new EClass();

        when(studentRepo.findWithClassesById(studentId)).thenReturn(Optional.of(mockStudent));
        when(disciplineRepo.findById(disciplineId)).thenReturn(Optional.of(mockDiscipline));
        service.createClass(className, studentId, disciplineId);

        verify(repo, times(1)).save(argThat(eClass -> eClass.getName().equals(className) &&
                eClass.getStudent().equals(mockStudent) &&
                eClass.getDisciplines().contains(mockDiscipline)));
    }

    @Test
    void updateClass_Test() {
        // Test data
        int eClassId = 1;
        String className = "UpdatedClassName";
        int studentId = 2;
        int disciplineId = 2;
        EClass existingEClass = new EClass();
        Student mockStudent = new Student();
        Discipline mockDiscipline = new Discipline();

        when(repo.findWithStudentAndDisciplinesById(eClassId)).thenReturn(Optional.of(existingEClass));
        when(studentRepo.findById(studentId)).thenReturn(Optional.of(mockStudent));
        when(disciplineRepo.findById(disciplineId)).thenReturn(Optional.of(mockDiscipline));

        service.updateClass(eClassId, className, studentId, disciplineId);

        verify(repo, times(1)).save(argThat(updatedEClass -> updatedEClass.getName().equals(className) &&
                updatedEClass.getStudent().equals(mockStudent) &&
                updatedEClass.getDisciplines().contains(mockDiscipline)));
    }

    @Test
    void deleteClass_Test() {
        int eClassId = 1;

        service.deleteClass(eClassId);

        verify(repo, times(1)).deleteById(eClassId);
    }
}
