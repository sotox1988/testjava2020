package com.example.testjava.matias.people.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 3193698935904425109L;

    @Id
    @Column(name = "id_rut_student")
    private Long idRutStudent;
    @Column(name = "name", length = 250)
    private String name;
    @Column(name = "last_name", length = 250)
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @JoinColumn(name = "code_course_id", referencedColumnName = "id_code_course")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Long getIdRutStudent() { return idRutStudent; }

    public void setIdRutStudent(Long idRutStudent) { this.idRutStudent = idRutStudent; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public Course getCourse() { return course; }

    public void setCourse(Course course) { this.course = course; }
}
