# Implement-CRUD-operation-test

## Implement an endpoint to perform CRUD operation on below table. You can use the IDE/dev environment of your choice. Please be ready to explain the tools and technology used to implement the same.  A proper solution implementation should following the best industry practices of devops /configuration management. 

## Tools and Technologies Used:
Spring Boot
Java 17
Spring Data JPA
MySQL Database
Maven
Postman
 


It has the following features –

- Create user
- Read single user
- Read all users
- Update user
- Delete user
- Delete all users


### 1) Create User REST API:

Request URL: http://localhost:8080/api/users

HTTP Method: POST

Request Body:

{
    "id": 1,
    "first_name": "Raj",
    "last_name": "Verma",
    "email": "raj.verma@imagine.com ",
    "age": 44
}


### 2) Get User REST API:

Request URL: http://localhost:8080/api/users/1

HTTP Method: GET


### 3) Update User REST API:

Request URL: http://localhost:8080/api/users/1

HTTP Method: PUT


### 4) Get All Users REST API:

Request URL: http://localhost:8080/api/users

HTTP Method: GET


### 5) DELETE User REST API:

Request URL: http://localhost:8080/api/users/1

HTTP Method: DELETE


### 6) DELETE All User REST API:

Request URL: http://localhost:8080/api/users

HTTP Method: DELETE
