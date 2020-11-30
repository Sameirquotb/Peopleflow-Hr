package com.peopleflw.hr.service;

import com.peopleflw.hr.entity.Employee;
import com.peopleflw.hr.entity.EmployeeState;
import com.peopleflw.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        // All mapping to DTO should be applied here
        // All DTO validation should be applied here
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployeeStatus(Long employeeId, EmployeeState state) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()) {
            employee.get().setState(state);
            employeeRepository.save(employee.get());
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
