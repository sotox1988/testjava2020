package com.example.testjava.matias.people.model.dto;


import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

public class StudentDTO implements Serializable {
    private static final long serialVersionUID = 6809204689427414904L;

    private String rut;
    @Length(max = 250, message = "El largo máximo ha sido sobrepasado (250)")
    private String name;
    @Length(max = 250, message = "El largo máximo ha sido sobrepasado (250)")
    private String lastName;
    private Integer age;
    private List<CourseDTO> courses;

    public String getRut() { return rut; }

    public void setRut(String rut) { this.rut = rut; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public List<CourseDTO> getCourses() { return courses; }

    public void setCourses(List<CourseDTO> courses) { this.courses = courses; }
}
