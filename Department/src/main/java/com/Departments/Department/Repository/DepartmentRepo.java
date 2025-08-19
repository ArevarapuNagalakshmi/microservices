package com.Departments.Department.Repository;

import com.Departments.Department.Entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Departments,String> {
   Departments findBydepartmentCode(String departmentCode);
}
