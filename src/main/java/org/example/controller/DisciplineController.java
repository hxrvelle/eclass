package org.example.controller;

import org.example.entity.dto.DisciplineDto;
import org.example.service.impl.DisciplineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    private DisciplineServiceImpl service;

    @Autowired
    public DisciplineController(DisciplineServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> getDisciplines() {
        List<DisciplineDto> disciplines = service.getAllDisciplines();
        return ResponseEntity.status(HttpStatus.OK).body(disciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable int id) {
        DisciplineDto discipline = service.getDisciplineById(id);
        return ResponseEntity.status(HttpStatus.OK).body(discipline);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDiscipline(@RequestParam String name) {
        service.createDiscipline(name);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateDiscipline(@PathVariable int id, @RequestParam String name) {
        service.updateDiscipline(id, name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDiscipline(@PathVariable int id) {
        service.deleteDiscipline(id);
    }
}
