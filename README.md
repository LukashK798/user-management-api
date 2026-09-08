# Users API - Spring Boot Backend

A modern, production-ready REST API for managing users, built with Spring Boot and Java. This project serves as a comprehensive backend portfolio piece demonstrating industry best practices, clean architecture, and modern Java tooling.

## 🚀 Features

- **Full CRUD REST API:** Endpoints for creating, reading, updating, and deleting users.
- **Clean Architecture:** Strict separation of concerns using the 3-tier Controller-Service-Repository pattern.
- **DTO Pattern:** Database entities are strictly isolated from the API layer using Data Transfer Objects.
- **Automated Mapping:** Seamless Entity <-> DTO translations using **MapStruct**.
- **Data Validation:** Strict input validation using Hibernate Validator (`@Valid`, `@NotBlank`, `@Email`).
- **Global Exception Handling:** Centralized error handling using `@RestControllerAdvice` for elegant, uniform JSON error responses (e.g., handling 404 Not Found).
- **Pagination:** Protected `getAllUsers` endpoint using Spring Data's `Pageable` to prevent Out-Of-Memory errors on large datasets.
- **Containerized Database:** PostgreSQL database spun up effortlessly via Docker Compose.
- **Unit Testing:** Service-layer tests written with **JUnit 5** and **Mockito** using the professional AAA (Arrange, Act, Assert) pattern.

## 🛠️ Technology Stack

- **Java 26**
- **Spring Boot 4.x** (Spring Web, Spring Data JPA, Spring Validation)
- **PostgreSQL** (Docker)
- **MapStruct** & **Lombok**
- **JUnit 5** & **Mockito**
- **Maven**

## 🏃‍♂️ How to run

1. Start the PostgreSQL database using Docker:
   ```bash
   docker-compose up -d
   ```
2. Run the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The API will be available at `http://localhost:8080/api/users`
