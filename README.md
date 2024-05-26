# Project-Apica
Contains the code for user management system for Apica

---

Since the [assignment](https://github.com/Ashishamar99/Project-Apica/blob/main/Java%20Assignment.pdf) is a bit vague, let's split it into 4 levels.

#### Level 1: Basic Structure and GET APIs

    User Service
        Create a Spring Boot project.
        Implement basic RESTful API endpoints for user registration and retrieval.
        Implement basic security configuration with Spring Security.
        Create Kafka producer to publish user events.

    Journal Service
        Create another Spring Boot project.
        Implement basic RESTful API endpoints for retrieving journals.
        Set up Kafka consumer to consume events from "user-events" topic.

#### Level 2: Additional APIs

    User Service
        Add API endpoints for updating and deleting user information.
        Implement role-based authentication using Spring Security.

    Journal Service
        Add more endpoints for CRUD operations on journals.
        Implement basic role-based access control for journal retrieval.

#### Level 3: Database Functionality

    User Service
        Integrate a database (e.g., MySQL, PostgreSQL) to store user details.
        Implement CRUD operations for user management using JPA/Hibernate.
    Journal Service
        Integrate a database to store journals.
        Implement CRUD operations for journals using JPA/Hibernate.

#### Level 4: Dockerization

    User Service
        Dockerize the User Service.
        Create a Dockerfile for packaging the Spring Boot application.
        Use Docker Compose to manage multiple containers.

    Journal Service
        Dockerize the Journal Service.
        Create a Dockerfile for packaging the Spring Boot application.
        Use Docker Compose to manage multiple containers.

This progression allows for incremental development and ensures that each level builds upon the previous one, ultimately leading to a fully functional system meeting the specified requirements.

---

### Steps to Run - 
- Clone the main branch.
- Install postgreSQL and launch pg admin tool.
- Give the database username and password in the application.properties file.
- Run Kafka using the command ```docker compose up -d```
- Now, import the project in Intellij or run mvn package and run the jar files.
- Import the postman-collection.json file in postman.
- Hit the endpoints to test out the application.

---