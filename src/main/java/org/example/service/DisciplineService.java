package org.example.service;

import org.example.entity.dto.DisciplineDto;

import java.util.List;

public interface DisciplineService {
    List<DisciplineDto> getAllDisciplines();
    DisciplineDto getDisciplineById(int id);
    void createDiscipline(String name);
    void updateDiscipline(int id, String name);
    void deleteDiscipline(int id);
}
