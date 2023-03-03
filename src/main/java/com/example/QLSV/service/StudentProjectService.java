package com.example.QLSV.service;

import com.example.QLSV.dto.StudentProjectDto;

import java.util.List;

public interface StudentProjectService {
    public List<StudentProjectDto> getAll();

    public StudentProjectDto save(StudentProjectDto studentProjectDto);

    public boolean delete(long id);
}
