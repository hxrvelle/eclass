package org.example.dto;

import org.example.entity.Discipline;
import org.example.entity.Student;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EClassDto {
    private int id;
    private String name;
    private Student student;
    private Set<Discipline> disciplines = new HashSet<>();

    public EClassDto() {
    }

    public EClassDto(int id, String name, Student student, Set<Discipline> disciplines) {
        this.id = id;
        this.name = name;
        this.student = student;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(Set<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EClassDto eClassDto = (EClassDto) o;

        if (id != eClassDto.id) return false;
        if (!Objects.equals(name, eClassDto.name)) return false;
        if (!Objects.equals(student, eClassDto.student)) return false;
        return Objects.equals(disciplines, eClassDto.disciplines);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (disciplines != null ? disciplines.hashCode() : 0);
        return result;
    }
}
