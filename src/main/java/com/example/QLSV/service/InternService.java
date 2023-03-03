package com.example.QLSV.service;

import com.example.QLSV.dto.InternDto;

import java.util.List;

public interface InternService {
    public List<InternDto> getAll();

    public InternDto save(InternDto internDto);

    public boolean delete(long id);
}
