package com.example.testjava.matias.people.service.impl;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.model.mappers.StudentMapper;
import com.example.testjava.matias.people.repository.StudentRepository;
import com.example.testjava.matias.people.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public StudentDTO getStudentById(Long id) {
        return studentMapper.asStudentDTO(studentRepository.findByIdRutStudent(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this.studentMapper::asStudentDTO)
                .sorted(Comparator.comparing(StudentDTO::getName))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        return studentMapper.asStudentDTO(studentRepository.save(studentMapper.asStudent(studentDTO)));
    }
}
