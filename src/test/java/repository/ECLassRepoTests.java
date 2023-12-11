package repository;

import org.example.entity.Discipline;
import org.example.entity.EClass;
import org.example.entity.Student;
import org.example.repository.DisciplineRepo;
import org.example.repository.EClassRepo;
import org.example.repository.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import repository.configuration.MySQLContainerProperties;
import repository.configuration.TestConfig;

import javax.transaction.Transactional;
import java.util.*;

@SpringJUnitConfig(TestConfig.class)
@ExtendWith(MySQLContainerProperties.class)
@Transactional
public class ECLassRepoTests {
    @Autowired
    private EClassRepo repo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private DisciplineRepo disciplineRepo;
    @Test
    void findWithStudentAndDisciplinesById_Test() {
        int id = 1;
        Optional<EClass> eClass = repo.findWithStudentAndDisciplinesById(id);
        Assertions.assertEquals(1, eClass.get().getId());
        Assertions.assertEquals("Ученик 1", eClass.get().getStudent().getName());
        Assertions.assertEquals("Математика", eClass.get().getDisciplines().iterator().next().getName());
    }

    @Test
    void findAllWithStudentAndDisciplinesById_Test() {
        List<EClass> eClasses = repo.findAll();
        Assertions.assertEquals(1, eClasses.get(0).getId());
        Assertions.assertEquals(2, eClasses.get(1).getId());

        Assertions.assertEquals("Ученик 1", eClasses.get(0).getStudent().getName());
        Assertions.assertEquals("Ученик 2", eClasses.get(1).getStudent().getName());

        Assertions.assertEquals("Математика", eClasses.get(0).getDisciplines().iterator().next().getName());
        Assertions.assertEquals("Информатика", eClasses.get(1).getDisciplines().iterator().next().getName());
    }

    @Test
    void createClass_Test() {
         Optional<Student> student = studentRepo.findWithClassesById(1);

         Set<Discipline> disciplines = new HashSet<>();
         Optional<Discipline> discipline = disciplineRepo.findById(1);
         disciplines.add(discipline.get());

         EClass eClass = new EClass();
         eClass.setName("КТ-3");
         eClass.setStudent(student.get());
         eClass.setDisciplines(disciplines);

         repo.save(eClass);

         Optional<EClass> createdEClass = repo.findWithStudentAndDisciplinesById(3);
         Assertions.assertEquals(3, createdEClass.get().getId());
         Assertions.assertEquals("Ученик 1", createdEClass.get().getStudent().getName());
         Assertions.assertEquals("Математика", createdEClass.get().getDisciplines().iterator().next().getName());
    }

    @Test
    void updateClass_Test() {
        Optional<EClass> existingEClass = repo.findWithStudentAndDisciplinesById(1);

        Optional<Student> student = studentRepo.findById(1);

        Set<Discipline> disciplines = new HashSet<>();
        Optional<Discipline> discipline = disciplineRepo.findById(1);
        disciplines.add(discipline.get());

        EClass eClass = existingEClass.get();
        eClass.setName("КТ-10");
        eClass.setStudent(student.get());
        eClass.setDisciplines(disciplines);

        repo.save(eClass);

        Optional<EClass> updatedEClass = repo.findWithStudentAndDisciplinesById(1);
        Assertions.assertEquals(1, updatedEClass.get().getId());
        Assertions.assertEquals("КТ-10", updatedEClass.get().getName());
        Assertions.assertEquals("Математика", updatedEClass.get().getDisciplines().iterator().next().getName());
    }

    @Test
    public void deleteClass_Test() {
        repo.deleteById(1);
        Assertions.assertFalse(repo.existsById(1));
    }
}
