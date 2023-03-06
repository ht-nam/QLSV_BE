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
        project = null;
        student = null;
        mark = studentProject.getMark();
        startDate = studentProject.getStartDate();
        endDate = studentProject.getEndDate();
    }

    public StudentProjectDto(StudentProject studentProject, boolean isFullField) {
        id = studentProject.getId();
        project = studentProject.getProject() == null || !isFullField ? null : new ProjectDto(studentProject.getProject(), false);
        student = studentProject.getStudent() == null || !isFullField ? null : new StudentDto(studentProject.getStudent(), false);
        mark = studentProject.getMark();
        startDate = studentProject.getStartDate();
        endDate = studentProject.getEndDate();
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
