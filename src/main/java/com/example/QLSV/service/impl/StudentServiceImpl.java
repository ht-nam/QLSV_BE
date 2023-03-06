package com.example.QLSV.service.impl;

import com.example.QLSV.domain.Student;
import com.example.QLSV.dto.StudentDto;
import com.example.QLSV.repository.StudentRepository;
import com.example.QLSV.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public StudentDto getById(long id) {
        return new StudentDto(studentRepository.findById(id).get(), true);
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentRepository.save(studentDto.toStudent());
        student.setStudentProjects(null);
        student.setInterns(null);
        return new StudentDto(student, true);
    }

    @Override
    public boolean delete(long id) {
        try {
            studentRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
