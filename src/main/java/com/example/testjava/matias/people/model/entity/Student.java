package com.example.testjava.matias.people.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = 3193698935904425109L;

    @Id
    @Column(name = "id_student")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    @Column(name = "rut", unique = true)
    private String rut;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "last_name", length = 250)
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id","course_id"})})
    private List<Course> courses;

    public Long getIdStudent() { return idStudent; }

    public void setIdStudent(Long idStudent) { this.idStudent = idStudent; }

    public String getRut() { return rut; }

    public void setRut(String rut) { this.rut = rut; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public List<Course> getCourses() { return courses; }

    public void setCourses(List<Course> courses) { this.courses = courses; }
}
