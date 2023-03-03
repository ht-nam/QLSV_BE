package com.example.QLSV.repository;

import com.example.QLSV.domain.StudentProject;
import com.example.QLSV.dto.StudentProjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentProjectRepository extends JpaRepository<StudentProject, Long> {
    @Query("select new com.example.QLSV.dto.StudentProjectDto(e) from StudentProject e")
    List<StudentProjectDto> getAll();
}
