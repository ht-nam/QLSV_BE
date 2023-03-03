package com.example.QLSV.repository;

import com.example.QLSV.domain.Student;
import com.example.QLSV.domain.StudentProject;
import com.example.QLSV.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select new com.example.QLSV.dto.StudentDto(e) from Student e")
    List<StudentDto> getAll();

}
