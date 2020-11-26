package com.interview.employeeskills.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "techfield")
@Data
public class TechField {

    @Id
    @GeneratedValue
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;
}
