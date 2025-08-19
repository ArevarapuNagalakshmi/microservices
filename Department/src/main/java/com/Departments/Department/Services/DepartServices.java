package com.Departments.Department.Services;

import com.Departments.Department.Dto.DepartmentsDto;
import com.Departments.Department.Entity.Departments;
import com.Departments.Department.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartServices implements DepartmentService{
    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public DepartmentsDto savedepartment(DepartmentsDto departmentsDto) {

        Departments departments = new Departments(
               departmentsDto.getDeptId(),
                departmentsDto.getName(),
                departmentsDto.getBranch(),
                departmentsDto.getDepartmentCode()


        );
        Departments departments1=departmentRepo.save(departments);
        DepartmentsDto departmentsDto1= new DepartmentsDto(
                departments1.getDeptId(),
                departments1.getName(),
                departments1.getBranch(),
                departments1.getDepartmentCode()
        );
        return departmentsDto1;

    }

    @Override
    public DepartmentsDto getdepartment(String departmentCode) {
    Departments departments= departmentRepo.findBydepartmentCode(departmentCode);
              // .orElseThrow(()->new RuntimeException("To id is not found "+departmentCode));

        return new DepartmentsDto(
               departments.getDeptId(),
                departments.getName(),
                departments.getBranch(),
                departments.getDepartmentCode());

    }
}
