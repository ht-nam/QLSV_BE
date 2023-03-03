package com.example.QLSV.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_teacher")
public class Teacher extends Person {
    @Column(name = "teacher_id", unique = true)
    private long teacherId;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Teacher() {
        super();
    }

    public Teacher(long id, String name, String code, String address, int gender, Date birthday, long teacherId, Department department) {
        super(id, name, code, address, gender, birthday);
        this.teacherId = teacherId;
        this.department = department;
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
}
