package com.interview.employeeskills.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@Data
public class Skill {

    @Id
    @GeneratedValue
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

//    @Column(name="techfield")
//    private TechField techField;

    @Column(name="experience")
    private String experience;

    @Column(name="summary")
    private String summary;
}
