package com.example.QLSV.repository;

import com.example.QLSV.domain.Intern;
import com.example.QLSV.dto.InternDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {
    @Query("select new com.example.QLSV.dto.InternDto(e) from Intern e")
    List<InternDto> getAll();

    @Query("select new com.example.QLSV.dto.InternDto(e) from Intern e where  e.student.id= :id")
    List<InternDto> getAllById(@Param("id") long id);
}
