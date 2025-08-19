package com.Students.student.Service;

import com.Students.student.Dto.APIResponseDto;
import com.Students.student.Dto.StudentDto;

public interface StudentServices {
    StudentDto savestudent(StudentDto studentDto);
    APIResponseDto getstudent(Long studentId);
}
