package com.example.QLSV.service.impl;

import com.example.QLSV.domain.Project;
import com.example.QLSV.dto.ProjectDto;
import com.example.QLSV.repository.ProjectRepository;
import com.example.QLSV.repository.TeacherRepository;
import com.example.QLSV.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public ProjectDto getById(long id) {
        return new ProjectDto(projectRepository.findById(id).get(), true);
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project project = projectRepository.save(projectDto.toProject());
        if (projectDto.getTeacher() != null) {
            project.setTeacher(teacherRepository.findById(projectDto.getTeacher().getId()).get());
        }
        projectDto.setStudentProjects(null);
        return new ProjectDto(project, true);
    }

    @Override
    public boolean delete(long id) {
        try {
            projectRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
