package com.Students.student.Controller;

import com.Students.student.Dto.APIResponseDto;
import com.Students.student.Dto.StudentDto;
import com.Students.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/savestudent")
    public ResponseEntity<StudentDto> saveStudents(@RequestBody StudentDto studentDto) {
      StudentDto studentDto1=studentService.savestudent(studentDto);
        return new ResponseEntity<>(studentDto1, HttpStatus.CREATED);
    }
    @GetMapping("/{studentId}")
    public ResponseEntity<APIResponseDto> getStudent(@PathVariable Long studentId){
        APIResponseDto studentDto=studentService.getstudent(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }
}
