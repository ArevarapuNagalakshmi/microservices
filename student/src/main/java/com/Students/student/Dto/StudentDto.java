package com.Students.student.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentDto {
    private Long studentId;
    private String firstname;
    private String lastname;
    private String departmentCode;

    public StudentDto(Long studentId, String firstname, String lastname, String departmentCode) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentCode = departmentCode;
    }

    public StudentDto() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(departmentCode, that.departmentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstname, lastname, departmentCode);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
