package com.example.testjava.matias.people.model.mappers;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.model.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course asCourse(CourseDTO dto){
        Course course = null;
        if(dto != null){
            course = new Course();
            course.setName(dto.getName());
            course.setCode(dto.getCode());
        }
        return course;
    }

    public CourseDTO asCourseDTO(Course entity){
        CourseDTO courseDTO = null;
        if(entity != null){
            courseDTO = new CourseDTO();
            courseDTO.setName(entity.getName());
            courseDTO.setCode(entity.getCode());
        }
        return courseDTO;
    }
}
