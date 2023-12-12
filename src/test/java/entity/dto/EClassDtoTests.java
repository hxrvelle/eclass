package entity.dto;

import org.example.entity.Discipline;
import org.example.entity.Student;
import org.example.entity.dto.EClassDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EClassDtoTests {
    @Test
    public void testGettersAndSetters() {
        Student student = new Student(1, "John", new ArrayList<>());
        Discipline math = new Discipline(1, "Math");
        Discipline science = new Discipline(2, "Science");

        Set<Discipline> disciplines = new HashSet<>();
        disciplines.add(math);
        disciplines.add(science);

        EClassDto eClassDto = new EClassDto();
        eClassDto.setId(1);
        eClassDto.setName("Class A");
        eClassDto.setStudent(student);
        eClassDto.setDisciplines(disciplines);

        Assertions.assertEquals(1, eClassDto.getId());
        Assertions.assertEquals("Class A", eClassDto.getName());
        Assertions.assertEquals(student, eClassDto.getStudent());
        Assertions.assertEquals(disciplines, eClassDto.getDisciplines());
    }

    @Test
    public void testEqualsAndHashCode() {
        Student student = new Student(1, "John", new ArrayList<>());
        Discipline math = new Discipline(1, "Math");
        Discipline science = new Discipline(2, "Science");

        Set<Discipline> disciplines1 = new HashSet<>();
        disciplines1.add(math);
        disciplines1.add(science);

        Set<Discipline> disciplines2 = new HashSet<>();
        disciplines2.add(math);

        EClassDto eClassDto1 = new EClassDto(1, "Class A", student, disciplines1);
        EClassDto eClassDto2 = new EClassDto(1, "Class A", student, disciplines1);
        EClassDto eClassDto3 = new EClassDto(2, "Class B", student, disciplines2);

        Assertions.assertEquals(eClassDto1, eClassDto2);
        Assertions.assertNotEquals(eClassDto1, eClassDto3);

        Assertions.assertEquals(eClassDto1.hashCode(), eClassDto2.hashCode());
        Assertions.assertNotEquals(eClassDto1.hashCode(), eClassDto3.hashCode());
    }

}
