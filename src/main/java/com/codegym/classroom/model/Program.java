package com.codegym.classroom.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
