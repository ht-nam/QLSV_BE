package com.example.QLSV.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
//@Entity
//@Table(name = "tb_person")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private int gender;

    @Column(name = "birthday")
    private Date birthday;

    public Person() {
    }

    public Person(long id, String name, String code, String address, int gender, Date birthday) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
