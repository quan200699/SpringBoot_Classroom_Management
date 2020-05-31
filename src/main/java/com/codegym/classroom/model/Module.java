package com.codegym.classroom.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Program program;
}
