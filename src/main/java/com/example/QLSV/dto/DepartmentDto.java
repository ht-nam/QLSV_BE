package com.example.QLSV.dto;

import com.example.QLSV.domain.Department;

public class DepartmentDto {
    private long id;
    private String name;
    private String code;
    private DepartmentDto department;

    public DepartmentDto() {
    }

    public DepartmentDto(Department department) {
        id = department.getId();
        name = department.getName();
        code = department.getCode();
        this.department = department.getDepartment() == null ? null : new DepartmentDto(department.getDepartment());
    }

    public DepartmentDto(long id, String name, String code, DepartmentDto department) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.department = department;
    }

    public Department toDepartment() {
        return new Department(id, name, code, department == null ? null : department.toDepartment());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }
}
