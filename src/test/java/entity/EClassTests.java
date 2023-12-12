package entity;

import org.example.entity.Discipline;
import org.example.entity.EClass;
import org.example.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EClassTests {
    @Test
    public void testGettersAndSetters() {
        Student student = new Student(1, "John", new ArrayList<>());
        Discipline math = new Discipline(1, "Math");
        Discipline science = new Discipline(2, "Science");

        Set<Discipline> disciplines = new HashSet<>();
        disciplines.add(math);
        disciplines.add(science);

        EClass eClass = new EClass();
        eClass.setId(1);
        eClass.setName("Class A");
        eClass.setStudent(student);
        eClass.setDisciplines(disciplines);

        Assertions.assertEquals(1, eClass.getId());
        Assertions.assertEquals("Class A", eClass.getName());
        Assertions.assertEquals(student, eClass.getStudent());
        Assertions.assertEquals(disciplines, eClass.getDisciplines());
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

        EClass eClass1 = new EClass(1, "Class A", student, disciplines1);
        EClass eClass2 = new EClass(1, "Class A", student, disciplines1);
        EClass eClass3 = new EClass(2, "Class B", student, disciplines2);

        Assertions.assertEquals(eClass1, eClass2);
        Assertions.assertNotEquals(eClass1, eClass3);

        Assertions.assertEquals(eClass1.hashCode(), eClass2.hashCode());
        Assertions.assertNotEquals(eClass1.hashCode(), eClass3.hashCode());
    }

}
