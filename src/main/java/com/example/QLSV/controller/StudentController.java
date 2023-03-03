package com.example.QLSV.controller;

import com.example.QLSV.dto.StudentDto;
import com.example.QLSV.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public StudentDto save(StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public StudentDto update(StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) {
        return studentService.delete(id);
    }
}