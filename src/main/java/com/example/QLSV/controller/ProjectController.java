package com.example.QLSV.controller;

import com.example.QLSV.dto.ProjectDto;
import com.example.QLSV.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/project")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<ProjectDto> getAll() {
        return projectServiceImpl.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProjectDto getById(@PathVariable long id) {
        return projectServiceImpl.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ProjectDto save(@RequestBody ProjectDto projectDto) {
        return projectServiceImpl.save(projectDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ProjectDto update(@RequestBody ProjectDto projectDto) {
        return projectServiceImpl.save(projectDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) {
        return projectServiceImpl.delete(id);
    }
}
