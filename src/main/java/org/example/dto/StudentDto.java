package org.example.dto;

import java.sql.Date;
import java.util.Objects;

public class StudentDto {
    private int id;
    private String surname;
    private String name;
    private String group;
    private Date date;
    private int status;

    public StudentDto() {
    }

    public StudentDto(int id, String surname, String name, String group, Date date, int status) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentDto that = (StudentDto) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(group, that.group)) return false;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
