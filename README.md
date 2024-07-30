# Vehicle control management application for ParkMent 🚗 🏍️

## 📚 Table of Contents
- [About the project](#-about-the-project)
- [Features](#%EF%B8%8F-features)
- [Technologies Used](#-technologies-used)
- [Installation](#%EF%B8%8F-installation)
- [Usage](#-usage)
- [API Endpoints](#-api-endpoints)
- [Architecture](#️-architecture)
- [License](#-license)
- [Authorship](#-authorship)

## 💻 About the project

This application serves as a REST API for managing ParkMent's parking lots. It provides CRUD functionalities for branches and vehicles, handles vehicle entry and exit operations, and generates reports on these operations. ParkMent is a fictional company created for the purpose of this project.

## ⚙️ Features

- **Branch Management**: Create, read, update, and delete branches.
- **Vehicle Management**: Create, read, update, and delete vehicles.
- **Operations Management**: Record vehicle entries and exits.
- **Reporting**: Generate reports on vehicle operations.

## 🛠 Technologies Used

- **Java 17**
- **Spring Boot 3.3.2**
- **Maven**
- **PostgreSQL**
- **Flyway**
- **JPA (Java Persistence API)**
- **Spring Boot DevTools**
- **Lombok**
- **SpringDoc OpenAPI**

## ⬇️ Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/luizgustavo-a/vehicle-control.git
   cd vehicle-control
   ```

2. **Set up the database:**
   - Create a PostgreSQL database.
   - Configure the database connection in `application.properties`.

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

## 🚀 Usage

Once the application is running, you can access the API documentation via Swagger UI at `http://localhost:8080/swagger-ui.html`.

## 📌 API Endpoints

### Vehicle Management
- **List all vehicles:**
  - `GET /vehicle`

- **List vehicles in a branch:**
  - `GET /branch/{branchId}/vehicles`

- **Update a vehicle:**
  - `PUT /vehicle`

- **Create a vehicle:**
  - `POST /vehicle`

- **Delete a vehicle:**
  - `DELETE /vehicle/{id}`

- **Search a vehicle by id or license plate:**
  - `GET /vehicle/{identifier}`

### Branch Management
- **List all branches:**
  - `GET /branch`

- **Update a branch:**
  - `PUT /branch`

- **Create a branch:**
  - `POST /branch`

- **Delete a branch:**
  - `DELETE /branch/{id}`

- **Search a branch by ID:**
  - `GET /branch/{id}`

### Operations Management
- **Exit a vehicle:**
  - `POST /operation/{branchId}/exit/{vehicleId}`

- **Enter a vehicle:**
  - `POST /operation/{branchId}/entry` 
    - It creates the vehicle and automatically register its entrance in the branch
  - `POST /operation/{branchId}/entry/{vehicleId}`

- **Search an operation by ID:**
  - `GET /operation/{id}`

- **Get the last operation for a vehicle:**
  - `GET /operation/last/{vehicleId}`

### Reports
- **Generate a report of operations:**
  - `GET /operation/report`

## ✏️ Architecture

The application follows Clean Code architecture principles, ensuring separation of concerns and maintainability. The key layers are:

1. **Controllers**: Handle HTTP requests and map them to services.
2. **Use Cases and Gateways**: Contain business logic and interact with repositories.
3. **Repositories**: Interact with the database using JPA.
4. **Entities**: Represent the data model.

## 📜 License

This project is licensed under the Apache 2.0 License.

## 📝 Authorship

Personal study project developed by [Luiz Almeida](https://github.com/luizgustavo-a). 
