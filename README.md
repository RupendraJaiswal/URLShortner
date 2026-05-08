# URL Shortener Application

A simple and scalable URL Shortener application built using Spring Boot, Spring Data JPA, MySQL, and Swagger OpenAPI.

---

# Features

- Generate short URLs
- Redirect to original URLs
- Track click count
- Expiry support
- REST APIs
- Swagger Documentation
- MySQL Database Integration
- Layered Architecture

---

# Tech Stack

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- MySQL
- Lombok
- Maven
- Swagger OpenAPI

---

# Project Structure

```text
src/main/java/com/rupendra/urlShortner
│
├── controller
├── service
├── repository
├── entity
├── dto
├── config
├── util
└── UrlShortnerApplication.java
```

---

# API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| POST | /url-shortner/shorten | Generate Short URL |
| GET | /url-shortner/{code} | Redirect to Original URL |

---

# Swagger URLs

## Swagger UI

```text
http://localhost:8080/url-shortner/swagger-ui/index.html
```

## OpenAPI Docs

```text
http://localhost:8080/url-shortner/v3/api-docs
```

---

# Database Configuration

## Create Database

```sql
CREATE DATABASE url_shortener;
```

---

# application.properties

```properties
spring.application.name=urlShortner

spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=root
spring.datasource.password=admin

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
server.servlet.context-path=/url-shortner

app.base-url=http://localhost:8080/url-shortner/
```

---

# Maven Dependencies

## Required Dependencies

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- mysql-connector-j
- lombok
- springdoc-openapi-starter-webmvc-ui

---

# Run Application

## Clone Repository

```bash
git clone https://github.com/RupendraJaiswal/URLShortner.git
```

## Build Project

```bash
mvn clean install
```

## Run Application

```bash
mvn spring-boot:run
```

---

# API Testing

## Generate Short URL

### Request

```http
POST http://localhost:8080/url-shortner/shorten
```

### Request Body

```json
{
  "url": "https://www.google.com"
}
```

### Response

```json
{
  "originalUrl": "https://www.google.com",
  "shortUrl": "http://localhost:8080/url-shortner/aBc123"
}
```

---

# Redirect URL

```http
GET http://localhost:8080/url-shortner/aBc123
```

Automatically redirects to original URL.

---

# Entity Structure

## UrlMapping

| Field | Type |
|------|------|
| id | Long |
| originalUrl | String |
| shortCode | String |
| clickCount | Long |
| createdAt | LocalDateTime |
| expiryDate | LocalDateTime |

---


# Author

Rupendra Jaiswal

---

# License

This project is licensed under the MIT License.

