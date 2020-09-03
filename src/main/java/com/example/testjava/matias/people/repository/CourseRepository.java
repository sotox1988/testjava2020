package com.example.testjava.matias.people.repository;

import com.example.testjava.matias.people.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    Course findByCode(String code);
}
