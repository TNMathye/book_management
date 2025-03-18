# Book Management System

A RESTful API for managing books using Spring Boot and Java 21.

## Overview

This project provides a comprehensive book management system with features like:
- CRUD operations for books - DONE
- Input validation - TBD
- Error handling - TBD
- API documentation -TBD
- Search functionality - TBD
- Pagination - TBD

## Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- Lombok
- Hibernate Validator
- Swagger/OpenAPI
- JUnit & Mockito

## Prerequisites

- JDK 21
- Maven 3.6+

## Getting Started

### Clone the repository

```bash
git clone https://github.com/TNMathye/book_management.git
cd book_management
```

### Build and run the application

```bash
mvn clean install
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`.

## API Documentation

After starting the application, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/book/get-all` | Get all books |
| GET | `/book/get/{id}` | Get book by ID |
| POST | `/book/add` | Add a new book |
| PUT | `/book/update` | Update an existing book |
| DELETE | `/book/delete/{id}` | Delete a book by ID |
| PATCH | `/book/changeValues/{id}` | Partially update a book |

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── bookmanagement
│   │           └── book_management
│   │               ├── controller
│   │               │   └── BookController.java
│   │               ├── exception
│   │               │   └── GlobalExceptionHandler.java
│   │               ├── model
│   │               │   └── Book.java
│   │               ├── repository
│   │               │   └── BookRepo.java
│   │               └── service
│   │                   └── BookService.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── bookmanagement
                └── book_management
                    ├── controller
                    │   └── BookControllerTest.java
                    └── service
                        └── BookServiceTest.java
```

## Future Enhancements

- User authentication and authorization
- Advanced search functionality
- Category management
- Book reviews and ratings
- API versioning

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License
N/A
