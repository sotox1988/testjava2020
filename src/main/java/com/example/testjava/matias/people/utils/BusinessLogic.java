package com.example.testjava.matias.people.utils;

import com.example.testjava.matias.people.model.dto.CourseDTO;
import com.example.testjava.matias.people.model.entity.Course;
import com.example.testjava.matias.people.utils.exceptions.BusinessLogicException;

public class BusinessLogic {

    public void verifyStudentIsMinor(Integer age){
        if(age != null && age >= 18){
            throw new BusinessLogicException("The student's age must be under 18 years old");
        }
    }

    public void verifyStudentName(String name){
        if(name == null ||
                name.isEmpty()){
            throw new BusinessLogicException("The student's must have a name");
        }
    }

    public void verifyStudentLastName(String name){
        if(name == null ||
                name.isEmpty()){
            throw new BusinessLogicException("The student's must have a last name");
        }
    }
}
