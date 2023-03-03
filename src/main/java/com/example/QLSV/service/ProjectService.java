package com.example.QLSV.service;

import com.example.QLSV.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    public List<ProjectDto> getAll();

    public ProjectDto save(ProjectDto projectDto);

    public boolean delete(long id);
}
