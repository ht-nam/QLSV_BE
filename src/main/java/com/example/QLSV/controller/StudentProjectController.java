package com.example.QLSV.controller;

import com.example.QLSV.dto.StudentProjectDto;
import com.example.QLSV.service.impl.StudentProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/studentProject")
public class StudentProjectController {
    @Autowired
    private StudentProjectServiceImpl studentProjectService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<StudentProjectDto> getAll() {
        return studentProjectService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public StudentProjectDto save(@RequestBody StudentProjectDto studentProjectDto) {
        return studentProjectService.save(studentProjectDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public StudentProjectDto update(@RequestBody StudentProjectDto studentProjectDto) {
        return studentProjectService.save(studentProjectDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) {
        return studentProjectService.delete(id);
    }
}
