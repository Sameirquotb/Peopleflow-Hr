# Peopleflw Hr Module  
PeopleFlw (www.pplflw.com) is a global HR platform enabling companies to hire & onboard their employees internationally, at the push of a button. It is our mission to create opportunities for anyone to work from anywhere. As work is becoming even more global and remote, there has never been a bigger chance to build a truly global HR-tech company.

# Language , Frameworks and Libraries
 - Java 8.
 - Spring Boot, Spring Data and Spring Web.
 - Lombok.
 - Liquibase (Database migration tool)
# Running  the application 

 - Download and Install JDK 8 https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html .
 - Download code from Github repository.
 - Navigate to project folder /hr
 - Run 
 ```
./mvnw clean package  
 ```
 - Navigate to target folder
 ```
cd target/
 ```
 - Run 
 ```
java -jar *.jar  
 ```

# Suggested Enhancements

 - Using [Spring state machine](https://projects.spring.io/spring-statemachine/) instead of simple enum.
 - Use DTO in controller layer instead of the entity bean and use mapping libraries to map me between entities and DTOs and move validation annotations to DTOs.
 - Add Audit (createdAt, modifiedAt ... etc ) feature to Employee entity using  hibernate out of the box implementation.
 - Implement service security (Authentication).
 - Add pagination feature to spring repositories.
 - In Unit test, Load database with initial test data using libraries like DBUnit 
 
 

# End Points 

Please check swagger generated documentation  after running the server

http://localhost:8080/swagger-ui/
  
Currently the project proved tree end points :
  
- **List All Employees** : list all employees.  
  
End Point :  
``` 
Method : Get 
URL: /employee  
```  
Sample Output:  
  
```  
[
    {
        "id": 1,
        "firstName": "Mohamed",
        "lastName": "Sameir",
        "state": "APPROVED",
        "dateOfBirth": "2009-12-21",
        "salary": 30000.0,
        "email": "sameir@gmail.com"
    },
    {
        "id": 2,
        "firstName": "Isalam",
        "lastName": "Abdelrahman",
        "state": "ADDED",
        "dateOfBirth": "1990-01-01",
        "salary": 30000.0,
        "email": "islam@gmail.com"
    }
]
 ```

- **Add Employee** : list all employees.  
  
End Point :  
```  
Method : POST
URL: /employee  
```  
Input Payload Sample
```  
{
    "firstName": "Mohamed",
    "lastName" : "Sameir",
    "dateOfBirth": "2009-12-21",
    "salary" : 30000,
    "email" : "sameir@gmail.com"
}
 ```
Sample Output:  
  
```  
{
    "id": 1,
    "firstName": "Mohamed",
    "lastName": "Sameir",
    "state": "ADDED",
    "dateOfBirth": "2009-12-21",
    "salary": 30000.0,
    "email": "sameir@gmail.com"
}
 ```
 
Sample request payload validation error message

```  
{
    "status": "BAD_REQUEST",
    "message": "Validation failed for argument [0] in public com.peopleflw.hr.entity.Employee com.peopleflw.hr.controller.EmployeeController.createEmployee(com.peopleflw.hr.entity.Employee) with 3 errors: [Field error in object 'employee' on field 'firstName': rejected value [Mo]; codes [Size.employee.firstName,Size.firstName,Size.java.lang.String,Size]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.firstName,firstName]; arguments []; default message [firstName],250,3]; default message [First name size should be between 3 and 250 character]] [Field error in object 'employee' on field 'lastName': rejected value [Sa]; codes [Size.employee.lastName,Size.lastName,Size.java.lang.String,Size]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.lastName,lastName]; arguments []; default message [lastName],250,3]; default message [Last name size should be between 3 and 250 character]] [Field error in object 'employee' on field 'email': rejected value [sameir]; codes [Email.employee.email,Email.email,Email.java.lang.String,Email]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [employee.email,email]; arguments []; default message [email],[Ljavax.validation.constraints.Pattern$Flag;@29009254,.*]; default message [Invalid email address]] ",
    "errors": [
        "firstName: First name size should be between 3 and 250 character",
        "lastName: Last name size should be between 3 and 250 character",
        "email: Invalid email address"
    ]
}
 ```
 
- **Update Employee Status** : Update Employee Status.  
  
End Point :  
```  
Method : PUT
URL: /employee/{employeeId}/changestate?state={employeeStatus} 
Where :
employeeId : Employee id in database.
employeeStatus :  ADDED, IN-CHECK, APPROVED or ACTIVE
```  
Sample Output:  
  
```  
{
    "id": 1,
    "firstName": "Mohamed",
    "lastName": "Sameir",
    "state": "APPROVED",
    "dateOfBirth": "2009-12-21",
    "salary": 30000.0,
    "email": "sameir@gmail.com"
}
 ```