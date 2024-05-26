# Use a base image with Java installed
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and make it executable
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn

# Copy the pom.xml and source code
COPY pom.xml /app
COPY src /app/src

# Ensure the Maven wrapper is executable
RUN chmod +x /app/mvnw

ENV SPRING_DATASOURCE_URL jdbc:postgresql://host.docker.internal:5432/localpgdb
ENV KAFKA_ADVERTISED_HOST_NAME host.docker.internal:9092

# Package the application
RUN ./mvnw package

# Set the entry point for the container
CMD ["java", "-jar", "target/journalmanagement-0.0.1-SNAPSHOT.jar"]