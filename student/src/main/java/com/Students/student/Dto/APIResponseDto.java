package com.Students.student.Dto;

public class APIResponseDto {
    private StudentDto studentDto;
    private DepartmentsDto departmentsDto;

    public APIResponseDto(StudentDto studentDto, DepartmentsDto departmentsDto) {

    }

    public APIResponseDto() {
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public DepartmentsDto getDepartmentsDto() {
        return departmentsDto;
    }

    public void setDepartmentsDto(DepartmentsDto departmentsDto) {
        this.departmentsDto = departmentsDto;
    }
}
