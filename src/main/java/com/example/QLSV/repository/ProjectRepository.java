package com.example.QLSV.repository;

import com.example.QLSV.domain.Project;
import com.example.QLSV.dto.ProjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("select new com.example.QLSV.dto.ProjectDto(e) from Project e")
    List<ProjectDto> getAll();
}
