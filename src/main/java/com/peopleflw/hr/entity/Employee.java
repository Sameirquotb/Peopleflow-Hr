package com.peopleflw.hr.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "first_name", length = 250, nullable = false)
    String firstName;

    @Column(name = "last_name", length = 250, nullable = false)
    String lastName;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    EmployeeState state = EmployeeState.ADDED;

}
