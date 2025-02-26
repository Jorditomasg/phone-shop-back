# PhoneShopBack

## Project Setup

### Prerequisites
- Java 17
- Maven
- Docker & Docker Compose

## Features

- **Retrieve All Products**: Get a list of all available mobile devices.
- **Product Details**: Fetch specifications for a specific product.
- **Similar Products**: Retrieve recommendations based on a given product.
- **Optimized Data Mapping**: Internal domain model mapped to a frontend-friendly response format.
- **Performance Testing**: k6 integration for load testing.

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/JordiKing10/phone-shop-backend.git
   cd phone-shop-back
   ```

2. Build the project:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

The API will be available at `http://localhost:5000`.

---

## API Endpoints

### Get All Products
```
GET /product/
Response: [{ id: string, marca: string, modelo: string, precio: number, ... }]
```

### Get Product by ID
```
GET /product/{id}
Response: { id: string, marca: string, modelo: string, precio: number, colors: [], storages: [] }
```

### Get Similar Products
```
GET /product/{id}/similar
Response: [{ id: string, marca: string, modelo: string, precio: number, ... }]
```

---

## Technologies
- **Spring Boot 3.4.3**
- **Java 17**
- **Maven**
- **Docker & Docker Compose**
- **RestTemplate** for API communication
- **Lombok** for model simplification
- **JUnit & Mockito** for testing


## Running Tests

### Setup Mocks and Infrastructure
1. Ensure Docker is installed and file sharing for the `shared` folder is enabled.
2. Start the required services:
   ```sh
   docker-compose up -d simulado influxdb grafana
   ```
3. Verify the mocks:
   ```sh
   curl http://localhost:3001/product/1/similarids
   ```

### Execute API Tests
Run the tests using:
```sh
   docker-compose run --rm k6 run scripts/test.js
```

View test results in Grafana:
- Open `http://localhost:3000/d/Le2Ku9NMk/k6-performance-test`

---

## Notes
- The project implements a REST API to retrieve similar products.
- It fetches product details from predefined mock services.
- Ensure all dependencies are installed before running tests.
