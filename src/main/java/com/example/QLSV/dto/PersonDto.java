package com.example.QLSV.dto;

import com.example.QLSV.domain.Person;

import java.util.Date;

public class PersonDto {
    private long id;
    private String name;
    private String code;
    private String address;
    private int gender;
    private Date birthday;

    public PersonDto() {
    }

    public PersonDto(Person person) {
        id = person.getId();
        name = person.getName();
        code = person.getCode();
        address = person.getAddress();
        gender = person.getGender();
        birthday = person.getBirthday();
    }

    public PersonDto(long id, String name, String code, String address, int gender, Date birthday) {
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
