package com.example.QLSV.dto;


import com.example.QLSV.domain.Project;

public class ProjectDto {
    private long id;
    private String name;
    private String code;
    private TeacherDto teacher;

    public ProjectDto() {
    }

    public ProjectDto(Project project) {
        id = project.getId();
        name = project.getName();
        code = project.getCode();
        teacher = new TeacherDto(project.getTeacher());
    }

    public ProjectDto(long id, String name, String code, TeacherDto teacher) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.teacher = teacher;
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
}
