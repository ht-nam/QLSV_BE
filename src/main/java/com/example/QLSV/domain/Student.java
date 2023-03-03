package com.example.QLSV.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_student")
public class Student extends Person {

    @Column(name = "year")
    private String year;

    @Column(name = "person_id")
    private long person_id;

    @OneToMany(mappedBy = "student")
    private Set<StudentProject> studentProjects;

    @OneToMany(mappedBy = "student")
    private Set<Intern> interns;

    public Student() {
    }

    public Student(String year, long person_id, Set<StudentProject> studentProjects, Set<Intern> interns) {
        this.year = year;
        this.person_id = person_id;
        this.studentProjects = studentProjects;
        this.interns = interns;
    }

    public Student(long id, String name, String code, String address, int gender, Date birthday, String year, long person_id, Set<StudentProject> studentProjects, Set<Intern> interns) {
        super(id, name, code, address, gender, birthday);
        this.year = year;
        this.person_id = person_id;
        this.studentProjects = studentProjects;
        this.interns = interns;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    public Set<StudentProject> getStudentProjects() {
        return studentProjects;
    }

    public void setStudentProjects(Set<StudentProject> studentProjects) {
        this.studentProjects = studentProjects;
    }

    public Set<Intern> getInterns() {
        return interns;
    }

    public void setInterns(Set<Intern> interns) {
        this.interns = interns;
    }
}
