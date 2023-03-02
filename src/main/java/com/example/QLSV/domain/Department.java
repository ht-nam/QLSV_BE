package com.example.QLSV.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Department department;

    public Department() {
    }

    public Department(long id, String name, String code, Department department) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
