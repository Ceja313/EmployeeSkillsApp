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

@RequestMapping("/employees")
@RestController
public class EmployeeSkillController {

    private final EmployeeService employeeService;

    EmployeeSkillController(EmployeeService pEmployeeService) {
        employeeService = pEmployeeService;
    }

    /**
     * Example exception handler which is used to return the appropriate message for illegal argument exceptions.
     * @param illegalArgumentException exception to handle
     * @return the message of the exception to specify the issue.
     */
    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public String handleError(IllegalArgumentException illegalArgumentException) {
        return illegalArgumentException.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public String handleError(EmployeeNotFoundException employeeNotFoundException) {
        return employeeNotFoundException.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
    public String handleError(InvalidEmployeeDataException invalidEmployeeDataException) {
        return invalidEmployeeDataException.getMessage();
    }

    @GetMapping(value = "ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(value = "")
    public List<Employee> findAllEmployees(HttpServletResponse response) {
        List<Employee> employees = employeeService.findAllEmployees();
        response.addIntHeader("X-Total-Count", employees.size());
        return employees;
    }

    @PostMapping(value = "")
    @ResponseStatus(value=HttpStatus.CREATED)
    public void insertEmployee(Employee pEmployee) {
        employeeService.insertEmployee(pEmployee);
    }

    @GetMapping(value = "/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping(value = "/{employeeId}")
    public void updateEmployee(@PathVariable String employeeId, Employee pEmployee) {
        employeeService.updateEmployee(employeeId, pEmployee);
    }

    @DeleteMapping(value = "/{employeeId}")
//    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    // todo continue looking at those below - haven't done much with them yet
    @GetMapping(value = "/{employeeId}/skills")
    public List<Employee> getEmployeeTechnicalSkills(@PathVariable String employeeId) {
        List<Employee> employees = employeeService.findAllEmployees();
//        response.addIntHeader("X-Total-Count", employees.size());
        return employees;
    }

    @PostMapping(value = "/{employeeId}/skills")
    @ResponseStatus(value=HttpStatus.CREATED)
    public void insertSkillToEmployee(@PathVariable String employeeId) {
//        employeeService.insertEmployee(pEmployee);
    }

    @GetMapping(value = "/{employeeId}/skills/{skillId}")
    public Skill getEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
        return null;
    }

    @PutMapping(value = "/{employeeId}/skills/{skillId}")
    public void updateEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
//        return null;
    }

    @DeleteMapping(value = "/{employeeId}/skills/{skillId}")
//    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteEmployeeSkill(@PathVariable String employeeId, @PathVariable String skillId) {
//        return null;
    }
}
