package com.Departments.Department.Services;

import com.Departments.Department.Dto.DepartmentsDto;

public interface DepartmentService {
    DepartmentsDto savedepartment(DepartmentsDto departmentsDto);


    DepartmentsDto getdepartment(String departmentCode);
}
