package com.example.QLSV.repository;

import com.example.QLSV.domain.Teacher;
import com.example.QLSV.dto.TeacherDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("select new com.example.QLSV.dto.TeacherDto(e) from Teacher e")
    List<TeacherDto> getALl();
}
