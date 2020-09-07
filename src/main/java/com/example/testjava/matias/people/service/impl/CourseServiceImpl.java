package com.example.testjava.matias.people.service.impl;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.model.mappers.CourseMapper;
import com.example.testjava.matias.people.repository.CourseRepository;
import com.example.testjava.matias.people.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    @Transactional(readOnly = true)
    public CourseDTO getCourseById(String id) {
        return courseMapper.asCourseDTO(courseRepository.findByIdCodeCourse(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this.courseMapper::asCourseDTO)
                .sorted(Comparator.comparing(CourseDTO::getCode))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        return courseMapper.asCourseDTO(courseRepository.save(courseMapper.asCourse(courseDTO)));
    }

    @Override
    public void deleteCourse(CourseDTO courseDTO) {
        courseRepository.delete(courseMapper.asCourse(courseDTO));
    }
}
