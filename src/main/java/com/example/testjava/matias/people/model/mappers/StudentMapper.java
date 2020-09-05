package com.example.testjava.matias.people.model.mappers;

import com.example.testjava.matias.people.model.dto.StudentDTO;
import com.example.testjava.matias.people.model.entity.Student;
import com.example.testjava.matias.people.utils.RutConverter;
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
            RutConverter rc = new RutConverter();
            student.setIdRutStudent(rc.asInteger(dto.getRut()).longValue());
            student.setName(dto.getName());
            student.setLastName(dto.getLastName());
            student.setAge(dto.getAge());
            student.setCourse(courseMapper.asCourse(dto.getCourse()));
        }
        return student;
    }

    public StudentDTO asStudentDTO(Student entity){
        StudentDTO studentDTO = null;
        if(entity != null){
            studentDTO = new StudentDTO();
            RutConverter rc = new RutConverter();
            studentDTO.setRut(rc.asString(entity.getIdRutStudent().intValue()));
            studentDTO.setName(entity.getName());
            studentDTO.setLastName(entity.getLastName());
            studentDTO.setAge(entity.getAge());
            studentDTO.setCourse(courseMapper.asCourseDTO(entity.getCourse()));
        }
        return studentDTO;
    }
}
