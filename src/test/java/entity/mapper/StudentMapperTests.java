package entity.mapper;

import org.example.entity.Student;
import org.example.entity.dto.EClassDto;
import org.example.entity.dto.StudentDto;
import org.example.entity.mapper.StudentMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class StudentMapperTests {
    private final StudentMapper mapper = Mappers.getMapper(StudentMapper.class);
    @Test
    public void testEntityToDtoMapping() {
        EClassDto classADto = new EClassDto(1, "Class A", null, null);
        EClassDto classBDto = new EClassDto(2, "Class B", null, null);

        List<EClassDto> classesDto = new ArrayList<>();
        classesDto.add(classADto);
        classesDto.add(classBDto);

        Student studentEntity = new Student(1, "John", null);
        StudentDto studentDto = mapper.mapToDto(studentEntity);

        Assertions.assertEquals(studentEntity.getId(), studentDto.getId());
        Assertions.assertEquals(studentEntity.getName(), studentDto.getName());
    }

    @Test
    public void testDtoToEntityMapping() {
        EClassDto classADto = new EClassDto(1, "Class A", null, null);
        EClassDto classBDto = new EClassDto(2, "Class B", null, null);

        List<EClassDto> classesDto = new ArrayList<>();
        classesDto.add(classADto);
        classesDto.add(classBDto);

        StudentDto studentDto = new StudentDto(1, "John", classesDto);
        Student studentEntity = mapper.mapToEntity(studentDto);

        Assertions.assertEquals(studentDto.getId(), studentEntity.getId());
        Assertions.assertEquals(studentDto.getName(), studentEntity.getName());
    }

}
