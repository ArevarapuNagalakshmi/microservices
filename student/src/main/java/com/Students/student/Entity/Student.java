package com.Students.student.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstname;
    private String lastname;
    private String departmentCode;

    public Student(Long studentId, String firstname, String lastname, String departmentCode) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.departmentCode = departmentCode;
    }

    public Student() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname) && Objects.equals(departmentCode, student.departmentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstname, lastname, departmentCode);
    }

    @Override
    public String toString() {
        return "Student{" +
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
