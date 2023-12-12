package entity;

import org.example.entity.EClass;
import org.example.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTests {
    @Test
    public void testGettersAndSetters() {
        EClass classA = new EClass(1, "Class A", null, null);
        EClass classB = new EClass(2, "Class B", null, null);

        List<EClass> classes = new ArrayList<>();
        classes.add(classA);
        classes.add(classB);

        Student student = new Student();
        student.setId(1);
        student.setName("John");
        student.setClasses(classes);

        Assertions.assertEquals(1, student.getId());
        Assertions.assertEquals("John", student.getName());
        Assertions.assertEquals(classes, student.getClasses());
    }

    @Test
    public void testEqualsAndHashCode() {
        EClass classA = new EClass(1, "Class A", null, null);
        EClass classB = new EClass(2, "Class B", null, null);

        List<EClass> classes1 = new ArrayList<>();
        classes1.add(classA);
        classes1.add(classB);

        List<EClass> classes2 = new ArrayList<>();
        classes2.add(classA);

        Student student1 = new Student(1, "John", classes1);
        Student student2 = new Student(1, "John", classes1);
        Student student3 = new Student(2, "Jane", classes2);

        Assertions.assertEquals(student1, student2);
        Assertions.assertNotEquals(student1, student3);

        Assertions.assertEquals(student1.hashCode(), student2.hashCode());
        Assertions.assertNotEquals(student1.hashCode(), student3.hashCode());
    }

}
