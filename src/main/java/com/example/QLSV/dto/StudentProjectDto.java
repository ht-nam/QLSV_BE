package com.example.QLSV.dto;

import com.example.QLSV.domain.StudentProject;

import java.util.Date;

public class StudentProjectDto {
    private long id;
    private ProjectDto project;
    private StudentDto student;
    private double mark;
    private Date startDate;
    private Date endDate;

    public StudentProjectDto() {
    }

    public StudentProjectDto(StudentProject studentProject) {
        id = studentProject.getId();
        project = studentProject.getProject() == null ? null : new ProjectDto(studentProject.getProject());
        student = studentProject.getStudent() == null ? null : new StudentDto(studentProject.getStudent());
        mark = studentProject.getMark();
        startDate = studentProject.getStartDate();
        endDate = studentProject.getEndDate();
    }

    public StudentProjectDto(StudentProject studentProject, boolean haveProject, boolean haveStudent) {
        id = studentProject.getId();
        project = studentProject.getProject() == null || haveStudent == false ? null : new ProjectDto(studentProject.getProject());
        student = studentProject.getStudent() == null || haveStudent == false ? null : new StudentDto(studentProject.getStudent());
        mark = studentProject.getMark();
        startDate = studentProject.getStartDate();
        endDate = studentProject.getEndDate();
    }

    public StudentProjectDto(long id, ProjectDto project, StudentDto student, double mark, Date startDate, Date endDate) {
        this.id = id;
        this.project = project;
        this.student = student;
        this.mark = mark;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StudentProject toStudentProject() {
        StudentProject studentProject = new StudentProject(id, null, null, mark, startDate, endDate);
        studentProject.setProject(project == null ? null : project.toProject());
        studentProject.setStudent(student == null ? null : student.toStudent());
        return studentProject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
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
