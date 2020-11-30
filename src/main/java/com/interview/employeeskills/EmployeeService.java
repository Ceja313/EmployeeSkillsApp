package com.interview.employeeskills;

import com.interview.employeeskills.entities.Address;
import com.interview.employeeskills.entities.Employee;
import com.interview.employeeskills.exceptions.EmployeeNotFoundException;
import com.interview.employeeskills.exceptions.InvalidEmployeeDataException;
import com.interview.employeeskills.repositories.AddressRepo;
import com.interview.employeeskills.repositories.EmployeeRepo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service to hold business logic for the employee skills information.
 * @author jrcej
 */
@Component
public class EmployeeService {

    //https://stackoverflow.com/questions/20041051/how-to-judge-a-string-is-uuid-type
    private static final String UUID_REGEX = "/^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/";

    private final EmployeeRepo employeeRepo;

    private final AddressRepo addressRepo;

    /**
     * Constructor
     * @param pEmployeeRepo Employee Repo
     * @param pAddressRepo Address Repo
     */
    public EmployeeService(EmployeeRepo pEmployeeRepo, AddressRepo pAddressRepo) {
        employeeRepo = pEmployeeRepo;
        addressRepo  = pAddressRepo;
    }

    /**
     * Pull all employee data.
     * @return all employee data
     */
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAllEmployees();
    }

    /**
     * Insert a new employee.
     * @param pEmployee New employee to insert
     */
    public void insertEmployee(Employee pEmployee) {
        try {
            Address address = addressRepo.save(pEmployee.getAddress());
            pEmployee.setAddress(address);
            employeeRepo.save(pEmployee);
        } catch (Exception pException) {
            throw new InvalidEmployeeDataException("Invalid Perficient employee data sent to server.");
        }
    }

    /**
     * Pull employee by id.
     * @param pId id of employee to pull.
     * @return Employee
     */
    public Employee getEmployeeById(String pId) {
        validateEmployeeId(pId);
        return employeeRepo.findEmployeeById(pId);
    }

    /**
     * Update an employee.
     * @param pEmployeeId id of employee to update
     * @param pEmployee information of employee
     * @return updated employee
     */
    public Employee updateEmployee(String pEmployeeId, Employee pEmployee) {
        validateEmployeeId(pEmployeeId);
        try {
            return employeeRepo.save(pEmployee);
        } catch (Exception pException) {
            throw new InvalidEmployeeDataException("Invalid Perficient employee data sent to server.");
        }
    }

    /**
     * Delete employee.
     * @param pEmployeeId id of employee to delete
     */
    public void deleteEmployee(String pEmployeeId) {
        validateEmployeeId(pEmployeeId);
        employeeRepo.deleteById(Integer.valueOf(pEmployeeId));
    }

    /**
     * Validate an employee id.
     * @param pEmployeeId employee id to validate.
     */
    private void validateEmployeeId(String pEmployeeId) {
        if (!pEmployeeId.matches(UUID_REGEX)) {
            throw new IllegalArgumentException("Invalid ID format.");
        } else if (!employeeRepo.existsById(Integer.valueOf(pEmployeeId))) {
            throw new EmployeeNotFoundException("Perficient employee not found.");
        }
    }

}
