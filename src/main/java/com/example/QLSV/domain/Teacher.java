package com.example.QLSV.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_teacher")
public class Teacher extends Person {
    @Column(name = "teacher_id", unique = true)
    private long teacherId;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Intern> interns;

    public Teacher() {
        super();
    }

    public Teacher(long teacherId, Department department, Set<Intern> interns) {
        this.teacherId = teacherId;
        this.department = department;
        this.interns = interns.size() == 0 ? null : interns;
    }

    public Teacher(long id, String name, String code, String address, int gender, Date birthday, long teacherId, Department department, Set<Intern> interns) {
        super(id, name, code, address, gender, birthday);
        this.teacherId = teacherId;
        this.department = department;
        this.interns = interns;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Intern> getInterns() {
        return interns;
    }

    public void setInterns(Set<Intern> interns) {
        this.interns = interns;
    }
}
