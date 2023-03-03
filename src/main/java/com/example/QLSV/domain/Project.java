package com.example.QLSV.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<StudentProject> studentProjects;

    public Project() {
    }

    public Project(long id, String name, String code, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<StudentProject> getStudentProjects() {
        return studentProjects;
    }

    public void setStudentProjects(Set<StudentProject> studentProjects) {
        this.studentProjects = studentProjects;
    }
}
