package com.Departments.Department.Controller;

import com.Departments.Department.Dto.DepartmentsDto;
import com.Departments.Department.Services.DepartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartServices departServices;

    @PostMapping("/savedepartment")
    public ResponseEntity<DepartmentsDto> saveDepartment(@RequestBody DepartmentsDto departmentsDto) {
        DepartmentsDto departmentsDto1=departServices.savedepartment(departmentsDto);
        return new ResponseEntity<>(departmentsDto1, HttpStatus.CREATED);
    }
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentsDto> getdepartment(@PathVariable String departmentCode){
        DepartmentsDto departmentsDto=departServices.getdepartment(departmentCode);
        return new ResponseEntity<>(departmentsDto, HttpStatus.OK);
    }
}
