package com.example.testjava.matias.people.repository;

import com.example.testjava.matias.people.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByIdRutStudent(Long id);
}
