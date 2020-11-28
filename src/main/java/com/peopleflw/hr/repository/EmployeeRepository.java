package com.peopleflw.hr.repository;

import com.peopleflw.hr.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
