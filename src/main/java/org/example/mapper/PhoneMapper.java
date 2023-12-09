package org.example.mapper;

import org.example.dto.PhoneDto;
import org.example.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PhoneMapper {
    @Mapping(source = "id", target = "id")
    Phone mapToEntity(PhoneDto dto);
    PhoneDto mapToDto (Phone entity);
}
