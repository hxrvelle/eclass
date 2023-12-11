package org.example.entity.mapper;

import org.example.entity.dto.StudentDto;
import org.example.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {
    @Mapping(source = "id", target = "id")
    Student mapToEntity(StudentDto dto);
    StudentDto mapToDto(Student entity);
}
