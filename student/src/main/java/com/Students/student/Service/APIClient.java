package com.Students.student.Service;
import com.Students.student.Dto.DepartmentsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Department", url = "http://localhost:2005/department/")
public interface APIClient {
    @GetMapping("{departmentCode}")
    DepartmentsDto getdepartment(@PathVariable String departmentCode);
}
