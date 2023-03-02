package com.example.QLSV.controller;

import com.example.QLSV.dto.TeacherDto;
import com.example.QLSV.repository.TeacherRepository;
import com.example.QLSV.service.TeacherService;
import com.example.QLSV.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public TeacherDto save(@RequestBody TeacherDto teacherDto) {
        return teacherServiceImpl.save(teacherDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public TeacherDto update(@RequestBody TeacherDto teacherDto) {
        return teacherServiceImpl.save(teacherDto);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody long id) {
        return teacherServiceImpl.delete(id);
    }
}
