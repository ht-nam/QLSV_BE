package com.example.QLSV.service.impl;

import com.example.QLSV.domain.Department;
import com.example.QLSV.dto.DepartmentDto;
import com.example.QLSV.repository.DepartmentRepository;
import com.example.QLSV.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDto> getAll() {
        return departmentRepository.getAll();
    }

    @Override
    public DepartmentDto getById(long id) {
        return new DepartmentDto(departmentRepository.findById(id).get(), true);
    }

    @Override
    public boolean delete(long id) {
        try {
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        if (departmentDto.getDepartment() != null) {
            DepartmentDto department = new DepartmentDto(departmentRepository.save(departmentDto.toDepartment()), true);
            DepartmentDto father = new DepartmentDto(departmentRepository.findById(departmentDto.getDepartment().getId()).get(), true);
            department.setDepartment(father);
            return department;
        } else {
            return new DepartmentDto(departmentRepository.save(departmentDto.toDepartment()), true);
        }
    }

}
