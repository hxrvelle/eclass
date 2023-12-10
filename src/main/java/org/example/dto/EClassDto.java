package org.example.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class EClassDto {
    private int id;
    private String name;

    public EClassDto() {
    }

    public EClassDto(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EClassDto eClassDto = (EClassDto) o;

        if (id != eClassDto.id) return false;
        return Objects.equals(name, eClassDto.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EClassDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
