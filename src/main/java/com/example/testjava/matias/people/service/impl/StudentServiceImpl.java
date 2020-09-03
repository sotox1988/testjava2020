package com.example.testjava.matias.people.service.impl;

import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.model.mappers.StudentMapper;
import com.example.testjava.matias.people.repository.StudentRepository;
import com.example.testjava.matias.people.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public StudentDTO getStudentByRut(String rut) {
        return studentMapper.asStudentDTO(studentRepository.findByRut(rut));
    }
}
