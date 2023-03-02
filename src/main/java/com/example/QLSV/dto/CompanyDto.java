package com.example.QLSV.dto;

import com.example.QLSV.domain.Company;

public class CompanyDto {
    private long id;
    private String name;
    private String code;
    private String address;

    public CompanyDto(){}
    public CompanyDto(long id, String name, String code, String address) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
    }

    public CompanyDto(Company company){
        this.id = company.getId();
        this.name = company.getName();
        this.code = company.getCode();
        this.address =  company.getAddress();
    }

    public Company toCompany(){
        return new Company(id, name, code, address);
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
}
