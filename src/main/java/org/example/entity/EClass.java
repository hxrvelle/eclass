package org.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "class")
public class EClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToMany
    @JoinTable(name = "class_discipline",
            joinColumns = @JoinColumn(name = "id_class", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_discipline", referencedColumnName = "id")
    )
    private Set<Discipline> disciplines = new HashSet<>();

    public EClass() {
    }

    public EClass(int id, String name, Student student, Set<Discipline> disciplines) {
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

        EClass eClass = (EClass) o;

        if (id != eClass.id) return false;
        if (!Objects.equals(name, eClass.name)) return false;
        if (!Objects.equals(student, eClass.student)) return false;
        return Objects.equals(disciplines, eClass.disciplines);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (disciplines != null ? disciplines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", disciplines=" + disciplines +
                '}';
    }
}
