package com.peopleflw.hr.controller;

import com.peopleflw.hr.entity.Employee;
import com.peopleflw.hr.entity.EmployeeState;
import com.peopleflw.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
            return employeeService.addEmployee(employee);
    }

    @PutMapping("/{employeeId}/changestate")
    public ResponseEntity<Employee> changeState(@PathVariable Long employeeId, @RequestParam("state") EmployeeState state) {
        Optional<Employee> employee = employeeService.updateEmployeeStatus(employeeId, state);
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

}
