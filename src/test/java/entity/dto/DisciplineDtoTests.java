package entity.dto;

import org.example.entity.dto.DisciplineDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DisciplineDtoTests {
    @Test
    public void testGettersAndSetters() {
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setId(1);
        disciplineDto.setName("Math");

        Assertions.assertEquals(1, disciplineDto.getId());
        Assertions.assertEquals("Math", disciplineDto.getName());
    }

    @Test
    public void testEqualsAndHashCode() {
        DisciplineDto dto1 = new DisciplineDto(1, "Math");
        DisciplineDto dto2 = new DisciplineDto(1, "Math");
        DisciplineDto dto3 = new DisciplineDto(2, "Science");

        Assertions.assertEquals(dto1, dto2);
        Assertions.assertNotEquals(dto1, dto3);

        Assertions.assertEquals(dto1.hashCode(), dto2.hashCode());
        Assertions.assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    @Test
    public void testToString() {
        DisciplineDto disciplineDto = new DisciplineDto(1, "Math");
        String expected = "DisciplineDto{id=1, name='Math'}";

        Assertions.assertEquals(expected, disciplineDto.toString());
    }

}
