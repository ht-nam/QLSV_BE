package com.example.QLSV.service.impl;

import com.example.QLSV.domain.StudentProject;
import com.example.QLSV.dto.StudentProjectDto;
import com.example.QLSV.repository.ProjectRepository;
import com.example.QLSV.repository.StudentProjectRepository;
import com.example.QLSV.repository.StudentRepository;
import com.example.QLSV.service.StudentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProjectServiceImpl implements StudentProjectService {
    @Autowired
    private StudentProjectRepository studentProjectRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<StudentProjectDto> getAll() {
        return studentProjectRepository.getAll();
    }

    @Override
    public StudentProjectDto save(StudentProjectDto studentProjectDto) {
        StudentProject studentProject = studentProjectRepository.save(studentProjectDto.toStudentProject());
        studentProject.setProject(projectRepository.findById(studentProjectDto.getProject().getId()).get());
        studentProject.setStudent(studentRepository.findById(studentProjectDto.getStudent().getId()).get());
        return new StudentProjectDto(studentProject);
    }

    @Override
    public boolean delete(long id) {
        try {
            studentProjectRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
