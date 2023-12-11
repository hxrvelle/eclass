package repository;

import org.example.entity.Discipline;
import org.example.repository.DisciplineRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import repository.configuration.MySQLContainerProperties;
import repository.configuration.TestConfig;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringJUnitConfig(TestConfig.class)
@ExtendWith(MySQLContainerProperties.class)
@Transactional
public class DisciplineRepoTests {
    @Autowired
    private DisciplineRepo repo;

    @Test
    void getDisciplineById_Test() {
        int id = 1;
        Optional<Discipline> discipline = repo.findById(id);
        Assertions.assertEquals(1, discipline.get().getId());
        Assertions.assertEquals("Математика", discipline.get().getName());
    }

    @Test
    void getAllDisciplines_Test() {
        List<Discipline> disciplines = repo.findAll();
        Assertions.assertEquals(1, disciplines.get(0).getId());
        Assertions.assertEquals("Математика", disciplines.get(0).getName());

        Assertions.assertEquals(2, disciplines.get(1).getId());
        Assertions.assertEquals("Информатика", disciplines.get(1).getName());
    }

    @Test
    void createDiscipline_Test() {
        Discipline discipline = new Discipline();
        discipline.setName("Английский язык");
        repo.save(discipline);

        Optional<Discipline> createdDiscipline = repo.findById(3);

        Assertions.assertEquals(3, createdDiscipline.get().getId());
        Assertions.assertEquals("Английский язык", createdDiscipline.get().getName());
    }

    @Test
    void updateDiscipline_Test() {
        Optional<Discipline> existingDiscipline = repo.findById(1);
        Discipline discipline = existingDiscipline.get();
        discipline.setName("Немецкий язык");

        repo.save(discipline);

        Optional<Discipline> updatedDiscipline = repo.findById(1);
        Assertions.assertEquals(1, updatedDiscipline.get().getId());
        Assertions.assertEquals("Немецкий язык", updatedDiscipline.get().getName());

    }

    @Test
    void deleteDiscipline_Test() {

    }
}
