package com.example.testjava.matias.people.controllers;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{code}")
    public CourseDTO findCourseByCode(@PathVariable String code){
        CourseDTO courseDTO = courseService.getCourseByCode(code);
        return courseDTO;
    }

}
