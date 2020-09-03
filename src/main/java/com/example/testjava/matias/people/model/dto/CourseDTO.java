package com.example.testjava.matias.people.model.dto;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private static final long serialVersionUID = -4194190253647309468L;

    @Length(max = 250, message = "El largo máximo ha sido sobrepasado (250)")
    private String name;
    @Length(max = 4, message = "El largo máximo ha sido sobrepasado (4)")
    private String code;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

}
