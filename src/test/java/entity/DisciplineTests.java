package entity;

import org.example.entity.Discipline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DisciplineTests {
    @Test
    public void testGettersAndSetters() {
        Discipline discipline = new Discipline();
        discipline.setId(1);
        discipline.setName("Math");

        Assertions.assertEquals(1, discipline.getId());
        Assertions.assertEquals("Math", discipline.getName());
    }

    @Test
    public void testEqualsAndHashCode() {
        Discipline discipline1 = new Discipline(1, "Math");
        Discipline discipline2 = new Discipline(1, "Math");
        Discipline discipline3 = new Discipline(2, "Science");

        Assertions.assertEquals(discipline1, discipline2);
        Assertions.assertNotEquals(discipline1, discipline3);

        Assertions.assertEquals(discipline1.hashCode(), discipline2.hashCode());
        Assertions.assertNotEquals(discipline1.hashCode(), discipline3.hashCode());
    }

    @Test
    public void testToString() {
        Discipline discipline = new Discipline(1, "Math");
        String expected = "Discipline{id=1, name='Math'}";

        Assertions.assertEquals(expected, discipline.toString());
    }

}
