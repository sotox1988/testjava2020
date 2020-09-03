package com.example.testjava.matias.people.controllers;

import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{rut}")
    public StudentDTO findStudentByRut(@PathVariable String rut){
        StudentDTO studentDTO = studentService.getStudentByRut(rut);
        return studentDTO;
    }
}
