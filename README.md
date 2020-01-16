# Microservices-Clinic
Implementation of medical unit administration system based on Spring Framework. The system is set up as distributed microservices architecture with use of Spring Boot tools. Main functionality of that system is registration of users(patients, doctors), booking visits and managing medical units.   

## Structure
### Eureka
Service registry server.
### Zuul
API gateway.
### Authentication
Service responsible for authentication and authorization of users.
### Patient
Service implementing patient related logic.
### Doctor
Service implementing doctor related logic.
### Clinic
Service implementing clinic related logic.
