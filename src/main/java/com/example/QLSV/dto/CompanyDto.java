package com.example.QLSV.dto;

import com.example.QLSV.domain.Company;
import com.example.QLSV.domain.Intern;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CompanyDto {
    private long id;
    private String name;
    private String code;
    private String address;

    private Set<InternDto> interns;

    public CompanyDto() {
    }

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.code = company.getCode();
        this.address = company.getAddress();
        this.interns = null;
    }

    public CompanyDto(Company company, boolean isFullField) {
        this.id = company.getId();
        this.name = company.getName();
        this.code = company.getCode();
        this.address = company.getAddress();
        this.interns = null;
        if (isFullField && company.getInterns() != null) {
            this.interns = company.getInterns().stream().map(e -> new InternDto(e, false)).collect(Collectors.toSet());
        }
    }

    public Company toCompany() {
        Set<Intern> itns = new HashSet<>();
        if (interns == null) {
            itns = null;
        } else {
            itns = interns.stream().map(e -> e.toIntern()).collect(Collectors.toSet());
        }
        return new Company(id, name, code, address, itns);
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

    public Set<InternDto> getInterns() {
        return interns;
    }

    public void setInterns(Set<InternDto> interns) {
        this.interns = interns;
    }
}
