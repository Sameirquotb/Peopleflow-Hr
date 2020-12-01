package com.peopleflw.hr.repository;

import com.peopleflw.hr.entity.Employee;
import com.peopleflw.hr.entity.EmployeeState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    public void test_AddEmployee_valid(){

        Employee employee = new Employee();

        employee.setFirstName("Sameir");
        employee.setLastName("Quotb");

        Employee savedEmployee = employeeRepository.save(employee);

        assertEquals("Sameir", savedEmployee.getFirstName());
        assertEquals("Quotb", savedEmployee.getLastName());
        assertEquals(EmployeeState.ADDED, savedEmployee.getState());

    }

    @Test
    public void test_AddEmployee_WithoutFirstName(){

        Employee employee = new Employee();

        employee.setLastName("Quotb");

        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> employeeRepository.save(employee));

    }

    @Test
    public void test_AddEmployee_WithoutLastName(){

        Employee employee = new Employee();

        employee.setFirstName("Sameir");

        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> employeeRepository.save(employee));

    }

}