package com.example.QLSV.service;


import com.example.QLSV.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    public List<CompanyDto> getAll();

    public CompanyDto getById(long id);

    public CompanyDto save(CompanyDto companyDto);

    public boolean delete(long id);

    public List<CompanyDto> paging(int pageNo, int pageSize, String sortBy);

}
