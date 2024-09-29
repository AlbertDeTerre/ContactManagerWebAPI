# Contact Management Web API

This project is a Web API for managing contacts within a company. It is built using **Spring Boot** and provides functionalities for managing both **contacts** and **companies**. 

## Features

- **Contact Management**:
  - Create a contact
  - Update a contact
  - Delete a contact
  - Retrieve all contacts

- **Company Management**:
  - Create a company
  - Update a company
  - Find a company by its VAT number
  - Retrieve all companies

- **Contact & Company Integration**:
  - Assign a contact to a company

## Business Constraints

- A contact must have a **first name**, **last name**, and an **address**.
- A contact can work for one or more companies.
- A company must have an **address** and a **VAT number**.
- A contact can be either an **employee** or a **freelancer**:
  - Freelancers must have a **VAT number**.

## Technical Requirements

- **RESTful API**: The API is synchronous and uses JSON format for communication.
- **Swagger UI**: Available for API documentation.
- **JPA**: For data persistence.
- **Spring Boot**: Core framework for building the API.
- **In-memory Database**: This project uses **HSQLDB**.
- **Simplicity**: The project is designed to be as simple as possible.

## Getting Started

1. Clone the repository:
  
```bash
   git clone https://github.com/AlbertDeTerre/ContactManagerWebAPI.git
```

4. Navigate to the project repository:
```bash
   cd location/of/folder/ContactWebApi
```

3. Run the app:
```bash
  ./mvnw spring-boot:run
```

4. Access the Swagger UI page at:

```
  http://localhost:8080/swagger-ui/index.html
```

5. Other informations

  This application uses an in-memory HyperSQL database, which will be automatically initialized on startup.
