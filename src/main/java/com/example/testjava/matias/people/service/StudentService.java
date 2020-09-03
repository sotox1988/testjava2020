package com.example.testjava.matias.people.service;

import com.example.testjava.matias.people.model.dto.StudentDTO;

public interface StudentService {

    StudentDTO getStudentByRut(String rut);
}
