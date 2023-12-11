package org.example.service.impl;

import org.example.dto.EClassDto;
import org.example.dto.StudentDto;
import org.example.entity.Discipline;
import org.example.entity.EClass;
import org.example.entity.Student;
import org.example.mapper.EClassMapper;
import org.example.repository.DisciplineRepo;
import org.example.repository.EClassRepo;
import org.example.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Service
@Transactional
public class EClassServiceImpl {
    private EClassRepo repo;
    private StudentRepo studentRepo;
    private DisciplineRepo disciplineRepo;
    private EClassMapper mapper;

    @Autowired
    public EClassServiceImpl(EClassRepo repo, StudentRepo studentRepo, DisciplineRepo disciplineRepo, EClassMapper mapper) {
        this.repo = repo;
        this.studentRepo = studentRepo;
        this.disciplineRepo = disciplineRepo;
        this.mapper = mapper;
    }

    public List<EClassDto> getAllClasses() {
        List<EClass> eClasses = repo.findAll();
        return eClasses.stream().map(mapper::mapToDto).toList();
    }

    public EClassDto getEClassById(int id) {
        Optional<EClass> eClass = repo.findWithStudentAndDisciplinesById(id);
        return mapper.mapToDto(eClass.get());
    }

    public void createClass(String name, int studentId, int disciplineId) {
        Optional<Student> student = studentRepo.findWithClassesById(studentId);
        Optional<Discipline> discipline = disciplineRepo.findById(disciplineId);
        Set<Discipline> disciplines = new HashSet<>();
        disciplines.add(discipline.get());

        EClass eClass = new EClass();
        eClass.setName(name);
        eClass.setStudent(student.get());
        eClass.setDisciplines(disciplines);

        repo.save(eClass);
    }

    public void updateClass(int id, String name, int studentId, int disciplineId) {
        Optional<EClass> existingEClass = repo.findWithStudentAndDisciplinesById(id);

        Optional<Student> student = studentRepo.findById(studentId);

        Set<Discipline> disciplines = new HashSet<>();
        Optional<Discipline> discipline = disciplineRepo.findById(disciplineId);
        disciplines.add(discipline.get());

        EClass eClass = existingEClass.get();
        eClass.setName(name);
        eClass.setStudent(student.get());
        eClass.setDisciplines(disciplines);

        repo.save(eClass);
    }

    public void deleteClass(int id) {
        repo.deleteById(id);
    }
}
