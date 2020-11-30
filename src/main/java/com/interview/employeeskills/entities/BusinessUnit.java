package com.interview.employeeskills.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Jeff Ceja
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "BusinessUnit")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessUnit {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="Id", nullable = false, updatable = false, unique = true)
    private Integer id;

    @Column(name = "Name", updatable = false)
    private String name;

    @Column(name = "Description", updatable = false)
    private String description;

    @Column(name = "Code", updatable = false, unique = true)
    private String code;

    @Column(name = "Priority", updatable = false)
    private Integer priority;

    @Column(name = "Retired", updatable = false)
    private Boolean retired;


}
