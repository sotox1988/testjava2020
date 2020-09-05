package com.example.testjava.matias.people.controllers;

import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.service.CourseService;
import com.example.testjava.matias.people.service.StudentService;
import com.example.testjava.matias.people.utils.BusinessLogic;
import com.example.testjava.matias.people.utils.RutConverter;
import com.example.testjava.matias.people.utils.exceptions.BusinessLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

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
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        logicValidator(studentDTO);
        return studentService.saveStudent(studentDTO);
    }

    @PutMapping("/{id}")
    public StudentDTO editStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long id){
        StudentDTO studentDb = studentService.getStudentById(id);
        logicValidator(studentDb);
        return studentService.saveStudent(studentDb);
    }

    //Method for handle the businessLogic
    private void logicValidator(StudentDTO studentDTO){
        BusinessLogic businessLogic = new BusinessLogic();
        RutConverter rutConverter = new RutConverter();
        rutConverter.asInteger(studentDTO.getRut());
        businessLogic.verifyStudentIsMinor(studentDTO.getAge());
        businessLogic.verifyStudentName(studentDTO.getName());
        businessLogic.verifyStudentLastName(studentDTO.getLastName());
        if(studentDTO.getCourse() != null &&
                courseService.getCourseById(studentDTO.getCourse().getCode()) != null) {
            studentDTO.setCourse(studentDTO.getCourse());
        }else{
            throw new BusinessLogicException("The entered course does not exist");
        }
    }
}
