package com.example.QLSV.service;

import com.example.QLSV.dto.TeacherDto;
import com.example.QLSV.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeacherService {
    public List<TeacherDto> getAll();

    public TeacherDto save(TeacherDto teacherDto);

    public boolean delete(long id);
}
