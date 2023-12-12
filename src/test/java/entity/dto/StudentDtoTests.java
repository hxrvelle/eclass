package entity.dto;

import org.example.entity.dto.EClassDto;
import org.example.entity.dto.StudentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDtoTests {
    @Test
    public void testGettersAndSetters() {
        EClassDto classADto = new EClassDto(1, "Class A", null, null);
        EClassDto classBDto = new EClassDto(2, "Class B", null, null);

        List<EClassDto> classes = new ArrayList<>();
        classes.add(classADto);
        classes.add(classBDto);

        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("John");
        studentDto.setClasses(classes);

        Assertions.assertEquals(1, studentDto.getId());
        Assertions.assertEquals("John", studentDto.getName());
        Assertions.assertEquals(classes, studentDto.getClasses());
    }

    @Test
    public void testEqualsAndHashCode() {
        EClassDto classADto = new EClassDto(1, "Class A", null, null);
        EClassDto classBDto = new EClassDto(2, "Class B", null, null);

        List<EClassDto> classes1 = new ArrayList<>();
        classes1.add(classADto);
        classes1.add(classBDto);

        List<EClassDto> classes2 = new ArrayList<>();
        classes2.add(classADto);

        StudentDto studentDto1 = new StudentDto(1, "John", classes1);
        StudentDto studentDto2 = new StudentDto(1, "John", classes1);
        StudentDto studentDto3 = new StudentDto(2, "Jane", classes2);

        Assertions.assertEquals(studentDto1, studentDto2);
        Assertions.assertNotEquals(studentDto1, studentDto3);

        Assertions.assertEquals(studentDto1.hashCode(), studentDto2.hashCode());
        Assertions.assertNotEquals(studentDto1.hashCode(), studentDto3.hashCode());
    }

    @Test
    public void testToString() {
        EClassDto classADto = new EClassDto(1, "Class A", null, null);
        EClassDto classBDto = new EClassDto(2, "Class B", null, null);

        List<EClassDto> classes = new ArrayList<>();
        classes.add(classADto);
        classes.add(classBDto);

        StudentDto studentDto = new StudentDto(1, "John", classes);

        String expected = "StudentDto{id=1, name='John', classes=[" + classADto.toString() + ", " + classBDto.toString() + "]}";

        Assertions.assertEquals(expected, studentDto.toString());
    }
}
