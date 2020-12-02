package com.peopleflw.hr.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(max = 250, min = 3, message = "First name size should be between 3 and 250 character")
    @Column(name = "first_name", length = 250, nullable = false)
    String firstName;

    @Size(max = 250, min = 3, message = "Last name size should be between 3 and 250 character")
    @Column(name = "last_name", length = 250, nullable = false)
    String lastName;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    EmployeeState state = EmployeeState.ADDED;


    @Past(message = "Date of birth can't be in feature.")
    @Column(name = "dateOfBirth", nullable = false)
    LocalDate dateOfBirth;

    @Column(name = "salary")
    Double salary;

    @NotEmpty
    @Email(message = "Invalid email address")
    @Column(name = "email", nullable = false)
    String email;

}
