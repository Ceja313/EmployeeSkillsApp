package com.interview.employeeskills.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Employee {

    @Id
    @GeneratedValue
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

//    @Column(name="address")
//    private Address address;

    @Column(name="companyEmail")
    private String companyEmail;

    @Column(name="birthDate")
    private String birthDate;

    @Column(name="hiredDate")
    private String hiredDate;

    @Column(name="role")
    private String role;

    @Column(name="businessUnit")
    private String businessUnit;

//    @Column(name="skills")
//    private List<Skill> skills;

    @Column(name="assignedTo")
    private String assignedTo;
}
