package com.interview.employeeskills;

import com.interview.employeeskills.entities.Employee;
import com.interview.employeeskills.exceptions.EmployeeNotFoundException;
import com.interview.employeeskills.exceptions.InvalidEmployeeDataException;
import com.interview.employeeskills.repositories.EmployeeRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo pEmployeeRepo) {
        employeeRepo = pEmployeeRepo;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAllEmployees();
    }

    public void insertEmployee(Employee pEmployee) {
        try {
            employeeRepo.save(pEmployee);
        } catch (Exception pException) {
            throw new InvalidEmployeeDataException("Invalid Perficient employee data sent to server.");
        }
    }

    public Employee getEmployeeById(String pId) {
        validateEmployeeId(pId);
        return employeeRepo.findEmployeeById(pId);
    }

    public Employee updateEmployee(String pEmployeeId, Employee pEmployee) {
        validateEmployeeId(pEmployeeId);
        try {
            return employeeRepo.save(pEmployee);
        } catch (Exception pException) {
            throw new InvalidEmployeeDataException("Invalid Perficient employee data sent to server.");
        }
    }

    public void deleteEmployee(String pEmployeeId) {
        validateEmployeeId(pEmployeeId);
        employeeRepo.deleteById(Integer.valueOf(pEmployeeId));
    }

    public boolean validateEmployeeId(String pEmployeeId) {
        if (false) { // todo
            throw new IllegalArgumentException("Invalid ID format.");
        } else if (!employeeRepo.existsById(Integer.valueOf(pEmployeeId))) {
            throw new EmployeeNotFoundException("Perficient employee not found.");
        }

        return true;
    }

}
