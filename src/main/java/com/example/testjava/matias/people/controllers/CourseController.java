package com.example.testjava.matias.people.controllers;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{id}")
    public CourseDTO findCourseByCodeId(@PathVariable String id){
        CourseDTO courseDTO = courseService.getCourseById(id);
        return courseDTO;
    }

    @GetMapping("/")
    List<CourseDTO> getAllCourse(){
        List<CourseDTO> courseDTOList = courseService.getAllCourses();
        return courseDTOList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
        return courseService.saveCourse(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO editCourse(@RequestBody CourseDTO courseDTO, @PathVariable String id){
        CourseDTO courseDb = courseService.getCourseById(id);
        if(courseDTO.getName() != null && !courseDTO.getName().isEmpty()) {
            courseDb.setName(courseDTO.getName());
        }
        return courseService.saveCourse(courseDb);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(courseService.getCourseById(id));
    }

}
