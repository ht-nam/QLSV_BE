package com.example.QLSV.controller;

import com.example.QLSV.dto.CompanyDto;
import com.example.QLSV.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/company")
public class CompanyController {
    @Autowired
    private CompanyServiceImpl companyService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<CompanyDto> getAll() {
        return companyService.getAll();
    }

    @RequestMapping(value = "/getAll/{pageNo}/{pageSize}/{sortBy}", method = RequestMethod.GET)
    public List<CompanyDto> paging(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("sortBy") String sortBy) {
        return companyService.paging(pageNo, pageSize, sortBy);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CompanyDto save(@RequestBody CompanyDto companyDto) {
        return companyService.save(companyDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public CompanyDto update(@RequestBody CompanyDto companyDto) {
        return companyService.save(companyDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) {
        return companyService.delete(id);
    }
}
