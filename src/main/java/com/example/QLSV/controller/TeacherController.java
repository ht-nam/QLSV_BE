package com.example.QLSV.controller;

import com.example.QLSV.dto.TeacherDto;
import com.example.QLSV.repository.TeacherRepository;
import com.example.QLSV.service.TeacherService;
import com.example.QLSV.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<TeacherDto> getAll() {
        return teacherServiceImpl.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TeacherDto getById(@PathVariable("id") long id) {
        return teacherServiceImpl.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TeacherDto save(@RequestBody TeacherDto teacherDto) {
        return teacherServiceImpl.save(teacherDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public TeacherDto update(@RequestBody TeacherDto teacherDto) {
        return teacherServiceImpl.save(teacherDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") long id) {
        return teacherServiceImpl.delete(id);
    }
}
