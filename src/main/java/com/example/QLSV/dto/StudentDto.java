package com.example.QLSV.dto;

import com.example.QLSV.domain.Person;
import com.example.QLSV.domain.Student;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentDto extends PersonDto {
    private String year;
    private long personId;
    private Set<StudentProjectDto> studentProjects;
    private Set<InternDto> interns;

    public StudentDto() {
    }

    public StudentDto(Student student) {
        super(student);
        year = student.getYear();
        personId = student.getPerson_id();
        studentProjects = null;
        interns = null;
    }

    public StudentDto(Student student, boolean isFullField) {
        super(student);
        year = student.getYear();
        personId = student.getPerson_id();

        if (student.getStudentProjects() == null) {
            studentProjects = null;
        } else {
            studentProjects = student.getStudentProjects().stream().map(e -> new StudentProjectDto(e, false)).collect(Collectors.toSet());
        }

        if (student.getInterns() == null) {
            interns = null;
        } else {
            interns = student.getInterns().stream().map(e -> new InternDto(e, false)).collect(Collectors.toSet());
        }
    }

    public Student toStudent() {
        Student student = new Student(getId(), getName(), getCode(), getAddress(), getGender(), getBirthday(), getYear(), getPersonId(), null, null);
        if (studentProjects != null) {
            student.setStudentProjects(studentProjects.stream().map(e -> e.toStudentProject()).collect(Collectors.toSet()));
        }
        if (interns != null) {
            student.setInterns(interns.stream().map(e -> e.toIntern()).collect(Collectors.toSet()));
        }
        return student;
    }

    public StudentDto(String year, long personId, Set<StudentProjectDto> studentProjects, Set<InternDto> interns) {
        this.year = year;
        this.personId = personId;
        this.studentProjects = studentProjects;
        this.interns = interns;
    }

    public StudentDto(Person person, String year, long personId, Set<StudentProjectDto> studentProjects, Set<InternDto> interns) {
        super(person);
        this.year = year;
        this.personId = personId;
        this.studentProjects = studentProjects;
        this.interns = interns;
    }

    public StudentDto(long id, String name, String code, String address, int gender, Date birthday, String year, long personId, Set<StudentProjectDto> studentProjects, Set<InternDto> interns) {
        super(id, name, code, address, gender, birthday);
        this.year = year;
        this.personId = personId;
        this.studentProjects = studentProjects;
        this.interns = interns;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public Set<StudentProjectDto> getStudentProjects() {
        return studentProjects;
    }

    public void setStudentProjects(Set<StudentProjectDto> studentProjects) {
        this.studentProjects = studentProjects;
    }

    public Set<InternDto> getInterns() {
        return interns;
    }

    public void setInterns(Set<InternDto> interns) {
        this.interns = interns;
    }
}
