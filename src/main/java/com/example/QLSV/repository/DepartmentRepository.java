package com.example.QLSV.repository;

import com.example.QLSV.domain.Department;
import com.example.QLSV.dto.DepartmentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("select new com.example.QLSV.dto.DepartmentDto(e) from Department e")
    List<DepartmentDto> getAll();
}
