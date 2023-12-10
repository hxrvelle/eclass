package org.example.mapper;

import org.example.dto.DisciplineDto;
import org.example.entity.Discipline;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DisciplineMapper {
    @Mapping(source = "id", target = "id")
    Discipline mapToEntity(DisciplineDto dto);
    DisciplineDto mapToDto(Discipline entity);
}
