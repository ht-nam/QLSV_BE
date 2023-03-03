package com.example.QLSV.dto;

import com.example.QLSV.domain.Teacher;

public class TeacherDto extends PersonDto {
    private long teacherId;
    private DepartmentDto department;

    public TeacherDto() {
    }

    public TeacherDto(Teacher teacher) {
        super(teacher);
        teacherId = teacher.getTeacherId();
        department = new DepartmentDto(teacher.getDepartment());
    }

    public Teacher toTeacher() {
        Teacher teacher = new Teacher(getId(), getName(), getCode(), getAddress(), getGender(), getBirthday(), getTeacherId(), null);
        teacher.setDepartment(department == null ? null : department.toDepartment());
        return teacher;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto departmentDto) {
        this.department = departmentDto;
    }
}
