package com.Students.student.Service;

import com.Students.student.Dto.APIResponseDto;
import com.Students.student.Dto.DepartmentsDto;
import com.Students.student.Dto.StudentDto;
import com.Students.student.Entity.Student;
import com.Students.student.Repository.StudentRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentService implements StudentServices {
    @Autowired
    private StudentRepo studentRepo;

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private WebClient webClient;
//    @Autowired
//    private APIClient apiClient;

    @Override
    public StudentDto savestudent(StudentDto studentDto) {
        Student student= new Student(
              studentDto.getStudentId(),
                studentDto.getFirstname(),
                studentDto.getLastname(),
                studentDto.getDepartmentCode()

        );
        Student student1 =studentRepo.save(student);
        StudentDto studentDto1 = new StudentDto(
                student1.getStudentId(),
                student1.getFirstname(),
                student1.getLastname(),
                student1.getDepartmentCode()
        );
        return studentDto1;
    }
    @CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")

    @Override
    public APIResponseDto getstudent(Long studentId) {
        Student student= studentRepo.findBystudentId(studentId);
//        ResponseEntity<DepartmentsDto>responseEntity=restTemplate.getForEntity("http://localhost:2005/department/"+student.getDepartmentCode()
//                ,DepartmentsDto.class);
       // DepartmentsDto departmentsDto=responseEntity.getBody();


        DepartmentsDto departmentsDto=webClient.get()
                .uri("http://localhost:2005/department/"+student.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentsDto.class)
                .block();


   //     DepartmentsDto departmentsDto=apiClient.getdepartment(student.getDepartmentCode());

        StudentDto studentDto=new StudentDto(
                student.getStudentId(),
                student.getFirstname(),
                student.getLastname(),
                student.getDepartmentCode());

       APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setStudentDto(studentDto);
      apiResponseDto.setDepartmentsDto(departmentsDto);
        return apiResponseDto;
    }
    public APIResponseDto getDefaultDepartment(Long studentId,Exception exception){
        Student student= studentRepo.findBystudentId(studentId);
        DepartmentsDto departmentsDto=new DepartmentsDto();
      departmentsDto.setName("R&D Department");
      departmentsDto.setDepartmentCode("RD001 ");
//        DepartmentsDto departmentsDto1=webClient.get()
//                .uri("http://localhost:2005/department/"+student.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentsDto.class)
//                .block();
        StudentDto studentDto=new StudentDto(
                student.getStudentId(),
                student.getFirstname(),
                student.getLastname(),
                student.getDepartmentCode());

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setStudentDto(studentDto);
        apiResponseDto.setDepartmentsDto(departmentsDto);
        return apiResponseDto;
    }

}
