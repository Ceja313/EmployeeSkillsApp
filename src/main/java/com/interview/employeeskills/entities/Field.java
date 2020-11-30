package com.interview.employeeskills.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Jeff Ceja
 */
@Entity
@Table(name = "Field")
@Data
public class Field {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="type", nullable = false)
    private String type;
}
