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

    public CompanyDto(long id, String name, String code, String address, Set<InternDto> interns) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.interns = interns;
    }

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.code = company.getCode();
        this.address = company.getAddress();
        if (company.getInterns() != null || company.getInterns().size() == 0) {
            this.interns = company.getInterns().stream().map(e -> new InternDto(e)).collect(Collectors.toSet());
        } else {
            this.interns = null;
        }
    }

    public Company toCompany() {
        Set<Intern> itns = new HashSet<>();
        if (interns == null || interns.size() == 0) {
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
