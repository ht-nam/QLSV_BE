package com.example.QLSV.service.impl;

import com.example.QLSV.domain.Intern;
import com.example.QLSV.dto.InternDto;
import com.example.QLSV.repository.CompanyRepository;
import com.example.QLSV.repository.InternRepository;
import com.example.QLSV.repository.StudentRepository;
import com.example.QLSV.repository.TeacherRepository;
import com.example.QLSV.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternServiceImpl implements InternService {
    @Autowired
    private InternRepository internRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<InternDto> getAll() {
        return internRepository.getAll();
    }

    @Override
    public InternDto save(InternDto internDto) {
        Intern intern = internRepository.save(internDto.toIntern());
        intern.setTeacher(teacherRepository.findById(internDto.getTeacher().getId()).get());
        intern.setStudent(studentRepository.findById(internDto.getStudent().getId()).get());
        intern.setCompany(companyRepository.findById(internDto.getCompany().getId()).get());
        return new InternDto(intern);
    }

    @Override
    public boolean delete(long id) {
        try {
            internRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
