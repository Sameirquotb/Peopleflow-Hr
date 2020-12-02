package com.peopleflw.hr.repository;

import com.peopleflw.hr.entity.Employee;
import com.peopleflw.hr.entity.EmployeeState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;

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
        employee.setDateOfBirth(LocalDate.now().minusYears(30));
        employee.setEmail("sameir@gmail.com");

        Employee savedEmployee = employeeRepository.save(employee);

        assertEquals("Sameir", savedEmployee.getFirstName());
        assertEquals("Quotb", savedEmployee.getLastName());
        assertEquals(LocalDate.now().minusYears(30), savedEmployee.getDateOfBirth());
        assertEquals("sameir@gmail.com", savedEmployee.getEmail());
        assertEquals(EmployeeState.ADDED, savedEmployee.getState());

    }

    @Test
    public void test_AddEmployee_WithoutFirstName(){

        Employee employee = new Employee();

        employee.setLastName("Quotb");
        employee.setDateOfBirth(LocalDate.now().minusYears(30));
        employee.setEmail("sameir@gmail.com");

        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> employeeRepository.save(employee));

    }

    @Test
    public void test_AddEmployee_WithoutLastName(){

        Employee employee = new Employee();

        employee.setFirstName("Sameir");
        employee.setDateOfBirth(LocalDate.now().minusYears(30));
        employee.setEmail("sameir@gmail.com");

        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> employeeRepository.save(employee));

    }

    @Test
    public void test_AddEmployee_InvalidDoB(){

        Employee employee = new Employee();

        employee.setFirstName("Sameir");
        employee.setLastName("Quotb");
        employee.setDateOfBirth(LocalDate.now().plusDays(10));
        employee.setEmail("sameir@gmail.com");

        Assertions.assertThrows(ConstraintViolationException.class, ()-> employeeRepository.save(employee));

    }

    @Test
    public void test_AddEmployee_InvalidEmail(){

        Employee employee = new Employee();

        employee.setFirstName("Sameir");
        employee.setLastName("Quotb");
        employee.setDateOfBirth(LocalDate.now().minusYears(30));
        employee.setEmail("sameirgmail.com");

        Assertions.assertThrows(ConstraintViolationException.class, ()-> employeeRepository.save(employee));

    }

}