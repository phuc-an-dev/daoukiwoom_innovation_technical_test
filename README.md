# Daoukiwoom Innovation Technical Test

This is a Spring Boot 3 project for managing employees, tasks, departments, and lunch logs.  
It includes features such as task assignment with event notifications, department salary aggregation, and bulk lunch log management.

---

## Prerequisites

Before running the project, make sure you have installed:

- Java 21
- Maven 3.9.11
- A running MySQL database
- Optional: IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## Setup

1. **Clone the repository**

```bash
git clone https://github.com/phuc-an-dev/daoukiwoom_innovation_technical_test.git
cd daoukiwoom_innovation_technical_test
```

2. **Configure application properties**

Edit src/main/resources/application.yml with your database credentials:

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database_name
    username: your_db_user
    password: your_db_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

`ddl-auto: update will automatically create/update tables based on your entities. Use with caution in production.`

3. **Build the project**

```bash
mvn clean install
```

4. **Build the project**

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`


