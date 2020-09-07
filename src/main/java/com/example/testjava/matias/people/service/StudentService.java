package com.example.testjava.matias.people.service;

import com.example.testjava.matias.people.model.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    StudentDTO getStudentById(Long id);
    List<StudentDTO> getAllStudents();
    StudentDTO saveStudent(StudentDTO studentDTO);
}
