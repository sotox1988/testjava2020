package com.example.testjava.matias.people.service.impl;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.model.mappers.CourseMapper;
import com.example.testjava.matias.people.repository.CourseRepository;
import com.example.testjava.matias.people.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    @Transactional(readOnly = true)
    public CourseDTO getCourseByCode(String code) {
        return courseMapper.asCourseDTO(courseRepository.findByCode(code));
    }
}
