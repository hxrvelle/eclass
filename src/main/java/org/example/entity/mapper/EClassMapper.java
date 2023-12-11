package org.example.entity.mapper;

import org.example.entity.dto.EClassDto;
import org.example.entity.EClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EClassMapper {
    @Mapping(source = "id", target = "id")
    EClass mapToEntity(EClassDto dto);
    EClassDto mapToDto(EClass entity);
}
