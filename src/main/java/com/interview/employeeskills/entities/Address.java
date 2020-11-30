package com.interview.employeeskills.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Jeff Ceja
 */
@Entity
@Table(name = "address")
@Data
public class Address {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name="street", nullable = false)
    private String street;

    @Column(name="suite")
    private String suite;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="region", nullable = false)
    private String region;

    @Column(name="postal", nullable = false)
    private String postal;

    @Column(name="country", nullable = false)
    private String country;
}
