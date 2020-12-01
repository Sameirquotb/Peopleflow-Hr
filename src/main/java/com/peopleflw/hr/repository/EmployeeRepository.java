package com.peopleflw.hr.repository;

import com.peopleflw.hr.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    /***
     * This is a sample query message
     * @param firstName
     * @param lastName
     * @return List of employees have with provided first name ans last name.
     */
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
