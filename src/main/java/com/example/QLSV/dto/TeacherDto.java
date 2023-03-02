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
        Teacher teacher = new Teacher();
        teacher.setId(getId());
        teacher.setName(getName());
        teacher.setCode(getCode());
        teacher.setAddress(getAddress());
        teacher.setGender(getGender());
        teacher.setBirthday(getBirthday());
        teacher.setTeacherId(teacherId);
        teacher.setDepartment(department.toDepartment());
        return teacher;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public DepartmentDto getDepartmentDto() {
        return department;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.department = departmentDto;
    }
}
