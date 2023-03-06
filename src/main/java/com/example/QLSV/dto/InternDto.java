package com.example.QLSV.dto;

import com.example.QLSV.domain.Intern;
import com.example.QLSV.domain.Teacher;

import java.util.Date;

public class InternDto {
    private long id;
    private StudentDto student;
    private CompanyDto company;
    private TeacherDto teacher;
    private double mark;
    private Date startDate;
    private Date endDate;

    public InternDto() {
    }

    public InternDto(Intern intern) {
        id = intern.getId();
        student = null;
        company = null;
        teacher = null;
        mark = intern.getMark();
        startDate = intern.getStartDate();
        endDate = intern.getEndDate();
    }

    public InternDto(Intern intern, boolean isFullField) {
        id = intern.getId();
        mark = intern.getMark();
        startDate = intern.getStartDate();
        endDate = intern.getEndDate();

        student = intern.getStudent() == null || !isFullField ? null : new StudentDto(intern.getStudent(), false);
        company = intern.getCompany() == null || !isFullField ? null : new CompanyDto(intern.getCompany(), false);
        teacher = intern.getTeacher() == null || !isFullField ? null : new TeacherDto(intern.getTeacher(), false);
    }

    public Intern toIntern() {
        Intern intern = new Intern(id, null, null, null, mark, startDate, endDate);
        intern.setStudent(student == null ? null : student.toStudent());
        intern.setCompany(company == null ? null : company.toCompany());
        intern.setTeacher(teacher == null ? null : teacher.toTeacher());
        return intern;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
