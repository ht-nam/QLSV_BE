package com.example.QLSV.dto;

import com.example.QLSV.domain.StudentProject;

import java.util.Date;

public class StudentProjectDto {
    private long id;
    private ProjectDto projectDto;
    private StudentDto studentDto;
    private double mark;
    private Date startDate;
    private Date endDate;

    public StudentProjectDto() {
    }

    public StudentProjectDto(StudentProject studentProject) {
        id = studentProject.getId();
        projectDto = studentProject.getProject() == null ? null : new ProjectDto(studentProject.getProject());
        studentDto = studentProject.getStudent() == null ? null : new StudentDto(studentProject.getStudent());
        mark = studentProject.getMark();
        startDate = studentProject.getStartDate();
        endDate = studentProject.getEndDate();
    }

    public StudentProjectDto(long id, ProjectDto projectDto, StudentDto studentDto, double mark, Date startDate, Date endDate) {
        this.id = id;
        this.projectDto = projectDto;
        this.studentDto = studentDto;
        this.mark = mark;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StudentProject toStudentProject() {
        StudentProject studentProject = new StudentProject(id, null, null, mark, startDate, endDate);
        studentProject.setProject(projectDto == null ? null : projectDto.toProject());
        studentProject.setStudent(studentDto == null ? null : studentDto.toStudent());
        return studentProject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
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
