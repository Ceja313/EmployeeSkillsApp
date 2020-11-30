package com.interview.employeeskills.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Jeff Ceja
 */
@Entity
@Table(name = "employee")
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Employee {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "ContactEmail", nullable = true)
    private String contactEmail;

    @Column(name = "CompanyEmail", nullable = false)
    private String companyEmail;

    @Column(name = "BirthDate", nullable = false)
    private String birthDate;

    @Column(name = "HiredDate", nullable = false)
    private String hiredDate;

    @Column(name = "Skills", nullable = true)
    private String skills;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AddressId", referencedColumnName = "Id",nullable = false)
    private Address address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AssignedToId", nullable = true)
    private Employee assignedTo;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "BusinessUnit", nullable = false)
    private String businessUnit;
}
