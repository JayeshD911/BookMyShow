# BookMyShow

An interview-ready, Spring Boot based movie ticket booking backend inspired by BookMyShow. The application demonstrates a layered Java backend with JPA entities, DTOs, repositories, services, and REST controllers for user sign-up and booking movie seats.

## Table of Contents

- [Overview](#overview)
- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Domain Model](#domain-model)
- [REST API](#rest-api)
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [How to Run](#how-to-run)
- [Future Improvements](#future-improvements)
- [Interview Talking Points](#interview-talking-points)

## Overview

BookMyShow is a cinema ticket booking backend that models real-world booking workflows: users sign up, browse shows, and book seats for a selected movie in a theatre. The codebase is organized around standard backend patterns so it is easy to explain in interviews and easy to extend.

## Key Features

- User sign-up flow
- Movie booking flow for a particular show
- Seat-based booking model
- Theatre, screen, show, and movie domain modeling
- Payment and booking status tracking
- Clean separation between controllers, services, repositories, DTOs, and entities

## Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot
- **Persistence:** Spring Data JPA / Hibernate
- **Database:** MySQL
- **Build Tool:** Maven
- **Boilerplate Reduction:** Lombok
- **API Style:** REST
- **Persistence Annotations:** Jakarta Persistence

## Architecture

The application follows a layered architecture:

1. **Controller layer** receives REST requests.
2. **DTO layer** carries request/response data.
3. **Service layer** contains business logic.
4. **Repository layer** handles database access.
5. **Model layer** defines entities and relationships.

This structure keeps concerns isolated and makes the project easier to test, maintain, and explain in interviews.

## Domain Model

The main entities are:

- **User** — user profile and booking history
- **Booking** — booking record with status and total amount
- **Movie** — movie details such as title, genre, director, rating
- **Theatre** — theatre information and location
- **Screen** — physical screen inside a theatre
- **Show** — a specific screening of a movie at a given time
- **Seat** / **ShowSeat** — seat allocation and per-show seat state
- **Payment** — payment metadata and status
- **Region** — location grouping
- **BaseModel** — shared fields such as id and timestamps

## REST API

The project currently includes the following primary controllers:

### `UserController`

- **User sign-up** — creates a new user account

### `BookingController`

- **Book movie** — books seats for a selected show

> Note: Endpoint paths and request payloads can be confirmed directly from the controller and DTO classes.

## Project Setup

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL 8+

### Database

The application is configured to use a MySQL database.

If you are running it locally, make sure the database exists and update credentials in:

- `src/main/resources/application.properties`
- `application-secrets.properties`

## Configuration

Important configuration files:

- `src/main/resources/application.properties` — JPA and datasource settings
- `application-secrets.properties` — local secret / credential placeholder file

Typical settings include:

- MySQL JDBC URL
- Database username and password
- Hibernate `ddl-auto` setting
- SQL logging options

## How to Run

From the project root:

```powershell
mvn clean install
mvn spring-boot:run
```

If you prefer to run tests first:

```powershell
mvn test
```

## Future Improvements

- Add booking cancellation flow
- Add admin APIs for theatres, screens, shows, and movie management
- Add validation and centralized exception handling
- Add authentication and authorization
- Add pagination and filtering for show discovery
- Add unit and integration tests for services and controllers
- Add API documentation with Swagger / OpenAPI

## Folder Structure

```text
src/main/java/com/jayesh/BookMyShow
├── controllers
├── dtos
├── models
├── repos
└── services
```

## License

This project is intended for learning and portfolio demonstration.
