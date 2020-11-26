package com.interview.employeeskills.repositories;

import com.interview.employeeskills.entities.Employee;
import com.interview.employeeskills.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findEmployeeById(String pId);

    @Query(value="SELECT * FROM employee;", nativeQuery=true)
    List<Employee> findAllEmployees();

//    List<Skill> findAllById(String pId); // todo need to create a table with skills?
 }
