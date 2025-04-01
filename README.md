# student-portal-be-java
Backend Services for Student Portal

This is the backend service for the Student Portal, built using **Spring Boot** and **OpenJDK 21**. It provides various functionalities for student management, including user account creation, authentication, course registration, grades management, and more.

## Table of Contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Setup and Installation](#setup-and-installation)

## Features

## Technologies Used
- **Spring Boot 3**: The main framework for building the backend.
- **Spring Security**: Authentication and authorization via JWT.
- **Spring Data JPA**: For interacting with the PostgreSQL database.
- **PostgreSQL**: A relational database used to store student data.
- **Lombok**: To reduce boilerplate code.
- **Swagger/OpenAPI**: For API documentation.
- **JUnit & Testcontainers**: For testing and database containerization.
- **Kafka**: For event-driven architecture and message streaming.
- **Jaeger**: For distributed tracing and monitoring microservices.
- **Loki**: For centralized log aggregation.
- **Grafana**: For visualizing logs and metrics stored in Loki.
- **Docker**: For containerization and easy environment setup.

## Setup and Installation

### Prerequisites
Before setting up the project, ensure the following tools are installed:

1. **OpenJDK 21**: The project uses **OpenJDK 21.0.1 LTS** (Temurin distribution). If you don't have OpenJDK 21 installed, follow these steps:

   - To verify the version:
     ```bash
     java -version
     ```

     You should see:
     ```
     openjdk version "21.0.1" 2023-10-17 LTS
     OpenJDK Runtime Environment Temurin-21.0.1+12 (build 21.0.1+12-LTS)
     OpenJDK 64-Bit Server VM Temurin-21.0.1+12 (build 21.0.1+12-LTS, mixed mode, sharing)
     ```

   - If OpenJDK 21 is not installed, use **SDKMAN!** to install it:
   
     ```bash
     sdk install java 21-open
     ```

2. **Maven**: You can install Maven using SDKMAN! if it's not already installed:
   
   ```bash
   sdk install maven
