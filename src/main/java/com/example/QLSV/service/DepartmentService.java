package com.example.QLSV.service;

import com.example.QLSV.domain.Department;
import com.example.QLSV.dto.DepartmentDto;
import com.example.QLSV.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public List<DepartmentDto> getAll();

    public DepartmentDto save(DepartmentDto departmentDto);

    public boolean delete(long id);
}
