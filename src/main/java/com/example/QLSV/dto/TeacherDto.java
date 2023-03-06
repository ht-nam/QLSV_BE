package com.example.QLSV.dto;

import com.example.QLSV.domain.Teacher;

import java.util.Set;
import java.util.stream.Collectors;

public class TeacherDto extends PersonDto {
    private long teacherId;
    private DepartmentDto department;

    private Set<InternDto> interns;

    public TeacherDto() {
    }

    public TeacherDto(Teacher teacher) {
        super(teacher);
        teacherId = teacher.getTeacherId();
        department = null;
        interns = null;
    }

    public TeacherDto(Teacher teacher, boolean isFullField) {
        super(teacher);
        teacherId = teacher.getTeacherId();
        department = teacher.getDepartment() == null || !isFullField ? null : new DepartmentDto(teacher.getDepartment(), false);
        if (teacher.getInterns() == null || !isFullField) {
            interns = null;
        } else {
            interns = teacher.getInterns().stream().map(e -> new InternDto(e, false)).collect(Collectors.toSet());
        }
    }

    public Teacher toTeacher() {
        Teacher teacher = new Teacher(getId(), getName(), getCode(), getAddress(), getGender(), getBirthday(), getTeacherId(), null, null);
        teacher.setDepartment(department == null ? null : department.toDepartment());
        if (interns != null) {
            teacher.setInterns(interns.stream().map(e -> e.toIntern()).collect(Collectors.toSet()));
        }
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

    public Set<InternDto> getInterns() {
        return interns;
    }

    public void setInterns(Set<InternDto> interns) {
        this.interns = interns;
    }
}
