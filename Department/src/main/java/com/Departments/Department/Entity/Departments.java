package com.Departments.Department.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;
    private String name;
    private String branch;
    private String departmentCode;

    public Departments(Long deptId, String name, String branch, String departmentCode) {
        this.deptId = deptId;
        this.name = name;
        this.branch = branch;
        this.departmentCode = departmentCode;
    }

    public Departments() {
        super();
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return Objects.equals(deptId, that.deptId) && Objects.equals(name, that.name) && Objects.equals(branch, that.branch) && Objects.equals(departmentCode, that.departmentCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, name, branch, departmentCode);
    }

    @Override
    public String toString() {
        return "Departments{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
