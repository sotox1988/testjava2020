package com.example.testjava.matias.people.controllers;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.service.StudentService;
import com.example.testjava.matias.people.utils.RutConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentDTO findStudentByRut(@PathVariable Long id){
        StudentDTO studentDTO = studentService.getStudentById(id);
        return studentDTO;
    }

    @GetMapping("/")
    List<StudentDTO> getAllCourse(){
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return studentDTOList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody StudentDTO StudentDTO){
        return studentService.saveStudent(StudentDTO);
    }
}
