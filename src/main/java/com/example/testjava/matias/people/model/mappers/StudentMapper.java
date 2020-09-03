package com.example.testjava.matias.people.model.mappers;

import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentMapper {

    @Autowired
    private CourseMapper courseMapper;

    public Student asStudent(StudentDTO dto){
        Student student = null;
        if(dto != null){
            student = new Student();
            student.setRut(dto.getRut());
            student.setName(dto.getName());
            student.setLastName(dto.getLastName());
            student.setAge(dto.getAge());
            student.setCourses(dto.getCourses().stream().map(this.courseMapper::asCourse).collect(Collectors.toList()));
        }
        return student;
    }

    public StudentDTO asStudentDTO(Student entity){
        StudentDTO studentDTO = null;
        if(entity != null){
            studentDTO = new StudentDTO();
            studentDTO.setRut(entity.getRut());
            studentDTO.setName(entity.getName());
            studentDTO.setLastName(entity.getLastName());
            studentDTO.setAge(entity.getAge());
            studentDTO.setCourses(entity.getCourses().stream().map(this.courseMapper::asCourseDTO).collect(Collectors.toList()));
        }
        return studentDTO;
    }
}
