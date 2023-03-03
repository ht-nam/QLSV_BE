package com.example.QLSV.dto;


import com.example.QLSV.domain.Project;

import java.util.Set;
import java.util.stream.Collectors;

public class ProjectDto {
    private long id;
    private String name;
    private String code;
    private TeacherDto teacher;
    private Set<StudentProjectDto> studentProjects;

    public ProjectDto() {
    }

    public ProjectDto(Project project) {
        id = project.getId();
        name = project.getName();
        code = project.getCode();
        teacher = project.getTeacher() == null ? null : new TeacherDto(project.getTeacher());
        if (project.getStudentProjects() == null) {
            studentProjects = null;
        } else {
            studentProjects = project.getStudentProjects().stream().map(e -> new StudentProjectDto(e, false, false)).collect(Collectors.toSet());
        }
    }

    public ProjectDto(long id, String name, String code, TeacherDto teacher, Set<StudentProjectDto> studentProjects) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.studentProjects = studentProjects;
    }

    public Project toProject() {
        Project project = new Project(id, name, code, null);
        project.setTeacher(teacher == null ? null : teacher.toTeacher());
        return project;
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

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public Set<StudentProjectDto> getStudentProjects() {
        return studentProjects;
    }

    public void setStudentProjects(Set<StudentProjectDto> studentProjects) {
        this.studentProjects = studentProjects;
    }
}
