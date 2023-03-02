package com.example.QLSV.service.impl;

import com.example.QLSV.dto.TeacherDto;
import com.example.QLSV.repository.TeacherRepository;
import com.example.QLSV.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<TeacherDto> getAll() {
        return teacherRepository.getALl();
    }

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        return new TeacherDto(teacherRepository.save(teacherDto.toTeacher()));
    }

    @Override
    public boolean delete(long id) {
        try {
            teacherRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
