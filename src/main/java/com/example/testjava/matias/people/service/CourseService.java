package com.example.testjava.matias.people.service;

import com.example.testjava.matias.people.model.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO getCourseById(String code);
    List<CourseDTO> getAllCourses();
    CourseDTO saveCourse(CourseDTO courseDTO);
    void deleteCourse(CourseDTO courseDTO);

}
