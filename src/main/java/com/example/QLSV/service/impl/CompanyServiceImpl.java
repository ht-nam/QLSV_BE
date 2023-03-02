package com.example.QLSV.service.impl;

import com.example.QLSV.domain.Company;
import com.example.QLSV.dto.CompanyDto;
import com.example.QLSV.repository.CompanyRepository;
import com.example.QLSV.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDto> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        return new CompanyDto(companyRepository.save(companyDto.toCompany()));
    }

    @Override
    public boolean delete(long id) {
        try {
            companyRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<CompanyDto> paging(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Company> pageResult = companyRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent().stream().map(e -> new CompanyDto(e)).collect(Collectors.toList());
        } else {
            return new ArrayList<CompanyDto>();
        }
    }
}
