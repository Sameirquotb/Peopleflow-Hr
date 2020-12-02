package com.peopleflw.hr.service;

import com.peopleflw.hr.entity.Employee;
import com.peopleflw.hr.entity.EmployeeState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void updateEmployeeStatus() {

        Employee employee = new Employee();

        employee.setFirstName("Sameir");
        employee.setLastName("Quotb");
        employee.setDateOfBirth(LocalDate.now().minusYears(30));
        employee.setEmail("sameir@gmail.com");


        Employee savedEmployee = employeeService.addEmployee(employee);

        Optional<Employee> updatedEmployee = employeeService.updateEmployeeStatus(savedEmployee.getId(), EmployeeState.ACTIVE);

        assertTrue(updatedEmployee.isPresent());

        assertEquals(EmployeeState.ACTIVE, updatedEmployee.get().getState());

    }


    @Test
    void updateEmployeeStatus_notExist() {

        assertThrows(Throwable.class, () -> employeeService.updateEmployeeStatus(1000L, EmployeeState.ACTIVE));

    }
}