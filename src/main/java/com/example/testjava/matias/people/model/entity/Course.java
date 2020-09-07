package com.example.testjava.matias.people.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course")
public class Course implements Serializable {
    private static final long serialVersionUID = -2378769572392380723L;

    @Id
    @Column(name = "id_code_course", length = 4)
    private String idCodeCourse;
    @Column(name = "name", length = 250)
    private String name;

    public String getIdCodeCourse() { return idCodeCourse; }

    public void setIdCodeCourse(String idCodeCourse) { this.idCodeCourse = idCodeCourse; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
