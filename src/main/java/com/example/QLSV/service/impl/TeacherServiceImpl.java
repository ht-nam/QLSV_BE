package com.example.QLSV.service.impl;

import com.example.QLSV.domain.Teacher;
import com.example.QLSV.dto.InternDto;
import com.example.QLSV.dto.TeacherDto;
import com.example.QLSV.repository.DepartmentRepository;
import com.example.QLSV.repository.InternRepository;
import com.example.QLSV.repository.TeacherRepository;
import com.example.QLSV.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private InternRepository internRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<TeacherDto> getAll() {
        return teacherRepository.getALl();
    }

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = teacherRepository.save(teacherDto.toTeacher());
        teacher.setDepartment(departmentRepository.findById(teacherDto.getDepartment().getId()).get());
        teacher.setInterns(null);
        return new TeacherDto(teacher);
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
