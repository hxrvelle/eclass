package entity.mapper;

import org.example.entity.Discipline;
import org.example.entity.dto.DisciplineDto;
import org.example.entity.mapper.DisciplineMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class DisciplineMapperTests {
    private final DisciplineMapper mapper = Mappers.getMapper(DisciplineMapper.class);

    @Test
    public void testEntityToDtoMapping() {
        Discipline disciplineEntity = new Discipline(1, "Math");
        DisciplineDto disciplineDto = mapper.mapToDto(disciplineEntity);

        Assertions.assertEquals(disciplineEntity.getId(), disciplineDto.getId());
        Assertions.assertEquals(disciplineEntity.getName(), disciplineDto.getName());
    }

    @Test
    public void testDtoToEntityMapping() {
        DisciplineDto disciplineDto = new DisciplineDto(1, "Math");
        Discipline disciplineEntity = mapper.mapToEntity(disciplineDto);

        Assertions.assertEquals(disciplineDto.getId(), disciplineEntity.getId());
        Assertions.assertEquals(disciplineDto.getName(), disciplineEntity.getName());
    }

}
