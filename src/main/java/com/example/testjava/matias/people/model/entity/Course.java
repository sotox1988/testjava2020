package com.example.testjava.matias.people.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = -2378769572392380723L;

    @Id
    @Column(name = "id_course")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "code", unique = true, length = 4)
    private String code;

    public Long getIdCourse() { return idCourse; }

    public void setIdCourse(Long idCourse) { this.idCourse = idCourse; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }
}
