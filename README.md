# Task Management Service

This is a Task Management Service built with Spring Boot, Java, and JWT for authentication. The service includes user registration, login, and JWT token generation for secure access to protected resources.

## Table of Contents

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Architecture](#architecture)
5. [Setup and Installation](#setup-and-installation)
6. [Running the Application](#running-the-application)
7. [API Endpoints](#api-endpoints)
8. [Database Schema](#database-schema)
9. [Approach and Assumptions](#approach-and-assumptions)



## Introduction

The Task Management Service is designed to manage tasks for users. It allows users to sign up, log in, and manage their tasks. The service uses JWT for authentication to ensure secure access to the resources.

## Features

- User registration and login
- Password hashing for security
- JWT token generation and validation
- Task management (CRUD operations)

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Hibernate (JPA)
- MySQL
- Lombok
- Maven

## Architecture

The service follows a typical Spring Boot application architecture with controllers, services, and repositories. It uses Spring Security for authentication and JWT for secure communication between the client and server.

## Setup and Installation

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

### Installation

1. Clone the repository:

```bash
git clone https://github.com/dijucode/taskmanagement-service.git
cd taskmanagement-service
```

2. Configure the database:

Create a MySQL database and update the `application.properties` file with your database configuration.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanagementdb
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Install the dependencies:

```bash
mvn clean install
```

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:9000`.

## API Endpoints

### User Endpoints

- **POST /signup**: Register a new user
- **POST /login**: Login and get a JWT token

### Task Endpoints

- **GET /tasks**: Get all tasks (requires JWT token)
- **POST /tasks**: Create a new task (requires JWT token)
- **PUT /tasks/{id}**: Update a task (requires JWT token)
- **DELETE /tasks/{id}**: Delete a task (requires JWT token)

## Database Schema

### User Table

| Field    | Type    | Description           |
|----------|---------|-----------------------|
| id       | Long    | Primary key           |
| username | String  | Username of the user  |
| password | String  | Hashed password       |
| role     | String  | Role of the user      |

### Task Table

| Field      | Type   | Description              |
|------------|--------|--------------------------|
| id         | Long   | Primary key              |
| title      | String | Title of the task        |
| description| String | Description of the task  |
| user_id    | Long   | Foreign key to User table|



# Approach and Assumptions
## Approach
The Task Management Service uses JWT for user authentication and authorization, ensuring that only authenticated users can access protected endpoints. The service follows a standard architecture for Spring Boot applications, leveraging Spring Security for managing authentication and JWT for secure communication. User passwords are securely hashed using BCrypt encoder.

## Assumptions
### Database Configuration:
It is assumed that MySQL is used for the database, and the user has proper access rights to create and manage the database.
### Java and Maven: 
It is assumed that Java 11 or higher and Maven are installed on the local machine.
### Security: 
It is assumed that JWT is sufficient for the security requirements of the application. For more advanced security needs, additional measures might be necessary.
Application Port: The application is configured to run on port 9000. Ensure this port is available and not used by other services on your machine.
