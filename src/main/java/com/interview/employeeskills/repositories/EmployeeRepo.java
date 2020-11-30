package com.interview.employeeskills.repositories;

import com.interview.employeeskills.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Respository to hold employee queries.
 * @author Jeff Ceja
 */
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findEmployeeById(String pId);

    List<Employee> findAllEmployees();

 }
