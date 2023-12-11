package org.example.service.impl;

import org.example.entity.dto.DisciplineDto;
import org.example.entity.Discipline;
import org.example.entity.mapper.DisciplineMapper;
import org.example.repository.DisciplineRepo;
import org.example.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DisciplineServiceImpl implements DisciplineService {
    private DisciplineRepo repo;
    private DisciplineMapper mapper;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepo repo, DisciplineMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<DisciplineDto> getAllDisciplines() {
        List<Discipline> disciplines = repo.findAll();
        return disciplines.stream().map(mapper::mapToDto).toList();
    }

    @Override
    public DisciplineDto getDisciplineById(int id) {
        Optional<Discipline> discipline = repo.findById(id);
        return mapper.mapToDto(discipline.get());
    }

    @Override
    public void createDiscipline(String name) {
        Discipline discipline = new Discipline();
        discipline.setName(name);
        repo.save(discipline);
    }

    @Override
    public void updateDiscipline(int id, String name) {
        Optional<Discipline> existingDiscipline = repo.findById(id);
        Discipline discipline = existingDiscipline.get();
        discipline.setName(name);
        repo.save(discipline);
    }

    @Override
    public void deleteDiscipline(int id) {
        repo.deleteById(id);
    }
}
