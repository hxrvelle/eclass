package org.example.controller;

import org.example.dto.EClassDto;
import org.example.service.impl.EClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class EClassController {
    private EClassServiceImpl service;

    @Autowired
    public EClassController(EClassServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EClassDto>> getClasses() {
        List<EClassDto> eClasses = service.getAllClasses();
        return ResponseEntity.status(HttpStatus.OK).body(eClasses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EClassDto> getClassById(@PathVariable int id) {
        EClassDto eClass = service.getEClassById(id);
        return ResponseEntity.status(HttpStatus.OK).body(eClass);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClass(@RequestParam int studentId, @RequestParam int disciplineId, @RequestParam String name) {
        service.createClass(name, studentId, disciplineId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateClass(@PathVariable int id, @RequestParam int studentId, @RequestParam int disciplineId, @RequestParam String name) {
        service.updateClass(id, name, studentId, disciplineId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClass(@PathVariable int id) {
        service.deleteClass(id);
    }
}
