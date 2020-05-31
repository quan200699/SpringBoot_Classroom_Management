package com.codegym.classroom.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String classTime;

    private String module;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Classroom classroom;

    @ManyToOne
    private Lecture coach;

    @ManyToOne
    private Lecture instructor;

    @ManyToMany
    @JoinTable(name = "class_tutor",
            joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "tutor_id")})
    private Set<Lecture> tutors;
}
