package com.peopleflw.hr.controller;

import com.peopleflw.hr.entity.Employee;
import com.peopleflw.hr.entity.EmployeeState;
import com.peopleflw.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public Iterable<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
            return employeeRepository.save(employee);
    }

    @PutMapping("/{employeeId}/changestate")
    public ResponseEntity<Employee> changeState(@PathVariable Long employeeId, @RequestParam("state") EmployeeState state) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            employee.get().setState(state);
            employeeRepository.save(employee.get());
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
