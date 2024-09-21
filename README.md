# Electea Spring Boot Hibernate JPA Project

This project demonstrates the use of Spring Boot with Hibernate JPA, Lombok, and MySQL . It also includes information about using H2 database as an alternative database.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [H2 Database](#h2-database)
- [Using MySQL](#using-mysql)
- [Lombok](#lombok)

## Technologies Used
- Spring Boot
- Hibernate JPA
- Lombok
- MySQL 
- H2 database (optional)

## Project Setup
1. Ensure you have Java JDK 11 or later installed.
2. Clone this repository: `git clone https://github.com/yourusername/electra-spring-boot-hibernate-jpa.git`
3. Navigate to the project directory: `cd electra-spring-boot-hibernate-jpa`
4. Build the project: `./mvnw clean install` (or `mvnw clean install` on Windows)

## Using MySQL
To use MySQL instead of H2, follow these steps:

1. Add the MySQL dependency to your `pom.xml`:
   ```xml
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <scope>runtime</scope>
   </dependency>
   ```

2. Update `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

3. Create the MySQL database:
   ```sql
   CREATE DATABASE your_database_name;
   ```

4. Restart your application.


## Using H2 Database
The project uses `application.properties` for configuration. Here's a sample configuration:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# H2 Console Configuration
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## Running the Application
To run the application, use the following command:

```
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

This project uses H2 as the default in-memory database. You can access the H2 console at `http://localhost:8080/h2-console`. Use the following details to log in:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Lombok
This project uses Lombok to reduce boilerplate code. Ensure your IDE has Lombok plugin installed for proper support.

To use Lombok in your entities:

```java
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class YourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    // Other fields...
}
```

This setup allows you to use Lombok annotations like `@Data`, `@NoArgsConstructor`, and `@AllArgsConstructor` to automatically generate getters, setters, constructors, and other common methods.

For more information on Lombok, visit [Project Lombok](https://projectlombok.org/).
