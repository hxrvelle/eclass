package org.example.dto;

import org.example.entity.Student;

import javax.persistence.*;
import java.util.Objects;

public class PhoneDto {
    private int id;
    private String phoneNumber;
    private StudentDto student;

    public PhoneDto() {
    }

    public PhoneDto(int id, String phoneNumber, StudentDto student) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneDto phoneDto = (PhoneDto) o;

        if (id != phoneDto.id) return false;
        if (!Objects.equals(phoneNumber, phoneDto.phoneNumber))
            return false;
        return Objects.equals(student, phoneDto.student);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
