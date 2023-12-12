package entity.mapper;

import org.example.entity.Discipline;
import org.example.entity.EClass;
import org.example.entity.Student;
import org.example.entity.dto.EClassDto;
import org.example.entity.mapper.EClassMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EClassMapperTests {
    private final EClassMapper mapper = Mappers.getMapper(EClassMapper.class);
    @Test
    public void testEntityToDtoMapping() {
        Student student = new Student(1, "John", new ArrayList<>());
        Discipline math = new Discipline(1, "Math");
        Discipline science = new Discipline(2, "Science");

        Set<Discipline> disciplines = new HashSet<>();
        disciplines.add(math);
        disciplines.add(science);

        EClass eClassEntity = new EClass(1, "Class A", student, disciplines);
        EClassDto eClassDto = mapper.mapToDto(eClassEntity);

        Assertions.assertEquals(eClassEntity.getId(), eClassDto.getId());
        Assertions.assertEquals(eClassEntity.getName(), eClassDto.getName());
        Assertions.assertEquals(eClassEntity.getStudent(), eClassDto.getStudent());
        Assertions.assertEquals(eClassEntity.getDisciplines(), eClassDto.getDisciplines());
    }

    @Test
    public void testDtoToEntityMapping() {
        Student student = new Student(1, "John", new ArrayList<>());
        Discipline math = new Discipline(1, "Math");
        Discipline science = new Discipline(2, "Science");

        Set<Discipline> disciplines = new HashSet<>();
        disciplines.add(math);
        disciplines.add(science);

        EClassDto eClassDto = new EClassDto(1, "Class A", student, disciplines);
        EClass eClassEntity = mapper.mapToEntity(eClassDto);

        Assertions.assertEquals(eClassDto.getId(), eClassEntity.getId());
        Assertions.assertEquals(eClassDto.getName(), eClassEntity.getName());
        Assertions.assertEquals(eClassDto.getStudent(), eClassEntity.getStudent());
        Assertions.assertEquals(eClassDto.getDisciplines(), eClassEntity.getDisciplines());
    }

}
