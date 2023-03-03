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
        student = intern.getStudent() == null ? null : new StudentDto(intern.getStudent());
        company = intern.getCompany() == null ? null : new CompanyDto(intern.getCompany());
        teacher = intern.getTeacher() == null ? null : new TeacherDto(intern.getTeacher());
        mark = intern.getMark();
        startDate = intern.getStartDate();
        endDate = intern.getEndDate();
    }

    public InternDto(long id, StudentDto student, CompanyDto company, TeacherDto teacher, double mark, Date startDate, Date endDate) {
        this.id = id;
        this.student = student;
        this.company = company;
        this.teacher = teacher;
        this.mark = mark;
        this.startDate = startDate;
        this.endDate = endDate;
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
