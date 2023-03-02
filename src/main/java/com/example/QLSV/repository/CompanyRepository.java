package com.example.QLSV.repository;

import com.example.QLSV.domain.Company;
import com.example.QLSV.dto.CompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select new com.example.QLSV.dto.CompanyDto(e) from Company e")
    public List<CompanyDto> getAll();
}
