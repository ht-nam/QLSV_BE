package com.example.QLSV.controller;

import com.example.QLSV.dto.InternDto;
import com.example.QLSV.service.impl.InternServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/intern")
public class InternController {
    @Autowired
    private InternServiceImpl internService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<InternDto> getAll() {
        return internService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public InternDto save(@RequestBody InternDto internDto) {
        return internService.save(internDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public InternDto update(@RequestBody InternDto internDto) {
        return internService.save(internDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable long id) {
        return internService.delete(id);
    }
}
