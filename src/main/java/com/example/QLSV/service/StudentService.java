package com.example.QLSV.service;

import com.example.QLSV.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getAll();

    public StudentDto getById(long id);

    public StudentDto save(StudentDto studentDto);

    public boolean delete(long id);
}
