package com.interview;

import com.interview.employeeskills.EmployeeService;
import com.interview.employeeskills.entities.Employee;
import com.interview.employeeskills.entities.Skill;
import com.interview.employeeskills.exceptions.EmployeeNotFoundException;
import com.interview.employeeskills.exceptions.InvalidEmployeeDataException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Controller for employee skill operations.
 * @author jrcej
 */
@RequestMapping("/employees")
@RestController
public class EmployeeSkillController {

    private final EmployeeService employeeService;

    /**
     * Constructor.
     */
    EmployeeSkillController(EmployeeService pEmployeeService) {
        employeeService = pEmployeeService;
    }

    /**
     * Example exception handler which is used to return the appropriate message for illegal argument exceptions.
     * @param illegalArgumentException exception to handle
     * @return the message of the exception to specify the issue.
     */
    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.BAD_REQUEST) // 400
    public String handleError(IllegalArgumentException illegalArgumentException) {
        return illegalArgumentException.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.NOT_FOUND) // 404
    public String handleError(EmployeeNotFoundException employeeNotFoundException) {
        return employeeNotFoundException.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY) // 422
    public String handleError(InvalidEmployeeDataException invalidEmployeeDataException) {
        return invalidEmployeeDataException.getMessage();
    }

    /**
     * Ping
     * @return Pong
     */
    @GetMapping(value = "ping")
    public String ping() {
        return "pong";
    }

    /**
     * Find all employees.
     * @param response response - needed for header addition
     * @return employees with the count in the header
     */
    @GetMapping(value = "")
    public List<Employee> findAllEmployees(HttpServletResponse response) {
        List<Employee> employees = employeeService.findAllEmployees();
        response.addIntHeader("X-Total-Count", employees.size());
        return employees;
    }

    /**
     * Insert a new employee.
     * @param pEmployee Employee to insert
     */
    @PostMapping(value = "")
    @ResponseStatus(value=HttpStatus.CREATED)
    public void insertEmployee(@RequestBody Employee pEmployee) {
        employeeService.insertEmployee(pEmployee);
    }

    /**
     * Pull an employee.
     * @param employeeId  id of employee to pull
     * @return employee with the id
     */
    @GetMapping(value = "/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    /**
     * Update an employee.
     * @param employeeId id of employee to update
     * @param pEmployee employee information to update with
     */
    @PutMapping(value = "/{employeeId}")
    public void updateEmployee(@PathVariable String employeeId, Employee pEmployee) {
        employeeService.updateEmployee(employeeId, pEmployee);
    }

    /**
     * Delete an employee.
     * @param employeeId id of employee to update
     */
    @DeleteMapping(value = "/{employeeId}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @GetMapping(value = "/{employeeId}/skills")
    public void getEmployeeTechnicalSkills(@PathVariable String employeeId, HttpServletResponse response) {
        // todo
    }

    @PostMapping(value = "/{employeeId}/skills")
    @ResponseStatus(value=HttpStatus.CREATED)
    public void insertSkillToEmployee(@PathVariable String employeeId) {
        // todo
    }

    @GetMapping(value = "/{employeeId}/skills/{skillId}")
    public void getEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
        // todo
    }

    @PutMapping(value = "/{employeeId}/skills/{skillId}")
    public void updateEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
        // todo
    }

    @DeleteMapping(value = "/{employeeId}/skills/{skillId}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
        // todo
    }
}
