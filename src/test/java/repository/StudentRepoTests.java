package repository;

import org.example.entity.Student;
import org.example.repository.StudentRepo;
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
public class StudentRepoTests {
    @Autowired
    private StudentRepo repo;

    @Test
    void findWithClassesById_Test() {
        int id = 1;
        Optional<Student> student = repo.findWithClassesById(id);
        Assertions.assertEquals(1, student.get().getId());
        Assertions.assertEquals("Ученик 1", student.get().getName());
        Assertions.assertEquals("КТ-1", student.get().getClasses().get(0).getName());
    }

    @Test
    void findAll_Test() {
        List<Student> students = repo.findAll();

        Assertions.assertEquals(1, students.get(0).getId());
        Assertions.assertEquals("Ученик 1", students.get(0).getName());
        Assertions.assertEquals("КТ-1", students.get(0).getClasses().get(0).getName());

        Assertions.assertEquals(2, students.get(1).getId());
        Assertions.assertEquals("Ученик 2", students.get(1).getName());
        Assertions.assertEquals("КТ-2", students.get(1).getClasses().get(0).getName());
    }

    @Test
    void createStudent_Test() {
        Student student = new Student();
        student.setId(3);
        student.setName("Ученик 3");
        repo.save(student);

        Optional<Student> createdStudent = repo.findById(3);

        Assertions.assertEquals(3, createdStudent.get().getId());
        Assertions.assertEquals("Ученик 3", createdStudent.get().getName());
    }

    @Test
    void updateStudent_Test() {
        Optional<Student> existingStudent = repo.findById(1);
        Student student = existingStudent.get();
        student.setId(1);
        student.setName("Ученик");

        repo.save(student);

        Optional<Student> updatedStudent = repo.findById(1);
        Assertions.assertEquals(1, updatedStudent.get().getId());
        Assertions.assertEquals("Ученик", updatedStudent.get().getName());
    }

    @Test
    void deleteStudent_Test() {
        repo.deleteById(1);
        Assertions.assertFalse(repo.existsById(1));
    }
}
