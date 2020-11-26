package com.interview.employeeskills.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name="street")
    private String street;

    @Column(name="suite")
    private String suite;

    @Column(name="city")
    private String city;

    @Column(name="region")
    private String region;

    @Column(name="postal")
    private String postal;

    @Column(name="country")
    private String country;
}
