```# Student Management REST API

A Spring Boot REST API for managing students and departments using Spring Data JPA, Hibernate, and MySQL.

## Overview

This project provides RESTful CRUD operations for students and departments.

It demonstrates:

- Spring Boot REST controllers
- Service and repository layers
- Spring Data JPA and Hibernate
- MySQL database persistence
- Entity relationships using `@OneToMany` and `@ManyToOne`
- Custom JPQL queries using `@Query`
- Request validation using Jakarta Validation
- Student search and course filtering
- JUnit 5 testing with MockMvc

## Tech Stack

- Java 17
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Jakarta Validation
- Maven
- JUnit 5
- MockMvc

## Project Structure

```text
student-management-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── suraksha
│   │   │           └── studentmanagementapi
│   │   │               ├── controller
│   │   │               │   ├── DepartmentController.java
│   │   │               │   └── StudentController.java
│   │   │               ├── entity
│   │   │               │   ├── Department.java
│   │   │               │   └── Student.java
│   │   │               ├── repository
│   │   │               │   ├── DepartmentRepository.java
│   │   │               │   └── StudentRepository.java
│   │   │               ├── service
│   │   │               │   ├── DepartmentService.java
│   │   │               │   └── StudentService.java
│   │   │               └── StudentManagementApiApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── suraksha
│                   └── studentmanagementapi
│                       ├── StudentControllerTest.java
│                       └── StudentManagementApiApplicationTests.java
└── pom.xml
```
Entity Relationship

The application contains two entities.

Department
ID
Name
Student
ID
Name
Email
Course
Age
Department

Relationship:
```
Department
|
| 1
|
| *
Student
```

A department can have multiple students, while each student belongs to one department.

The relationship is implemented using:

@OneToMany

and

@ManyToOne
API Endpoints
Student APIs
Method	Endpoint	Description
POST	/students	Create a student
GET	/students	Get all students
GET	/students/{id}	Get student by ID
PUT	/students/{id}	Update a student
DELETE	/students/{id}	Delete a student
GET	/students/course/{course}	Find students by course
GET	/students/search?name={name}	Search students by name
Department APIs
Method	Endpoint	Description
POST	/departments	Create a department
GET	/departments	Get all departments
GET	/departments/{id}	Get department by ID
PUT	/departments/{id}	Update a department
DELETE	/departments/{id}	Delete a department
Custom JPA Query

The StudentRepository contains a custom JPQL query:

@Query("SELECT s FROM Student s WHERE s.course = :course")
List<Student> findStudentsByCourse(@Param("course") String course);

The project also uses Spring Data derived query methods for searching students by name.

Validation

Student request data is validated using Jakarta Validation annotations.

The Student entity uses:

@NotNull
@Size
@Email

Example:

@NotNull
@Size(min = 2, max = 50)
private String name;

@NotNull
@Email
private String email;

Invalid request data results in a 400 Bad Request response.

Database Configuration

The application uses MySQL.

Create the database:

CREATE DATABASE student_management;

Configure the database connection in:

src/main/resources/application.properties

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081

Replace YOUR_MYSQL_PASSWORD with your local MySQL password.

Running the Application

Make sure MySQL is running and the student_management database exists.

On Windows:

.\mvnw.cmd spring-boot:run

The API runs on:

http://localhost:8081
Testing

Run all automated tests using:

.\mvnw.cmd test

The project includes:

Spring Boot application context testing
Student controller testing using MockMvc

Latest test result:

Tests run: 2
Failures: 0
Errors: 0
BUILD SUCCESS
Example Student Request
Create Student
POST /students
Content-Type: application/json
{
"name": "Rahul Kumar",
"email": "rahul@example.com",
"course": "Computer Science and Engineering",
"age": 21,
"department": {
"id": 1
}
}
Example Response
{
"name": "Rahul Kumar",
"email": "rahul@example.com",
"course": "Computer Science and Engineering",
"age": 21,
"department": {
"name": "Computer Science and Engineering",
"id": 1
},
"id": 2
}

## Key Features

- RESTful API development with Spring Boot
- Layered architecture using Controller, Service, and Repository
- CRUD operations
- JPA entity mapping
- One-to-many and many-to-one relationships
- MySQL persistence
- Custom JPQL queries
- Derived query methods
- Request validation
- Automated controller testing
- Maven build and test lifecycle

## Author

**Suraksha Shetty**

Java | Spring Boot | REST APIs | JPA | MySQL