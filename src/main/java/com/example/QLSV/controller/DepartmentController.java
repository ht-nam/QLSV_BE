package com.example.QLSV.controller;

import com.example.QLSV.dto.DepartmentDto;
import com.example.QLSV.repository.DepartmentRepository;
import com.example.QLSV.service.DepartmentService;
import com.example.QLSV.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentServiceImp;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<DepartmentDto> getAll() {
        return departmentServiceImp.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public DepartmentDto save(@RequestBody DepartmentDto departmentDto) {
        return departmentServiceImp.save(departmentDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public DepartmentDto update(@RequestBody DepartmentDto departmentDto) {
        return departmentServiceImp.save(departmentDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") long id) {
        return departmentServiceImp.delete(id);
    }

}
