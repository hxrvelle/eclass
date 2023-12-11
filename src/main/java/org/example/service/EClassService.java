package org.example.service;

import org.example.entity.dto.EClassDto;

import java.util.List;

public interface EClassService {
    List<EClassDto> getAllClasses();
    EClassDto getEClassById(int id);
    void createClass(String name, int studentId, int disciplineId);
    void updateClass(int id, String name, int studentId, int disciplineId);
    void deleteClass(int id);
}
