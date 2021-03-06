package com.interview.employeeskills.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Jeff Ceja
 */
@Entity
@Table(name = "skill")
@Data
public class Skill {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FieldId", nullable = false, insertable = false, updatable = false)
    private Field field;

    @Column(name="experience", nullable = false)
    private String experience;

    @Column(name="summary")
    private String summary;
}
