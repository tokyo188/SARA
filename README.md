# Resource Finder and Donator (SARA)

A Spring Boot + Thymeleaf full-stack web application for connecting volunteers, donors, and communities during disasters and urgent needs.

## Features

- **Resource Management**: Add, view, edit, and delete resources (food, water, medical supplies, shelter, etc.)
- **Volunteer Registration**: Register volunteers with their skills and availability
- **Donor Management**: Register donors and track donation types (monetary, goods, services)
- **Responsive UI**: Bootstrap 5 based frontend with modern, clean design
- **H2 Database**: In-memory database for easy development and testing
- **H2 Console**: Built-in database console for debugging

## Technology Stack

- **Backend**: Spring Boot 3.2.0
- **Frontend**: Thymeleaf templates with Bootstrap 5
- **Database**: H2 in-memory database
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Java Version**: Java 17

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- VS Code (optional but recommended)

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/tokyo188/SARA.git
cd SARA
```

### 2. Build the project

```bash
mvn clean package
```

### 3. Run the application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:9090`

### 4. Access the application

Open your web browser and navigate to:
- **Home Page**: http://localhost:9090
- **Resources**: http://localhost:9090/resources
- **Volunteers**: http://localhost:9090/volunteers
- **Donors**: http://localhost:9090/donors
- **H2 Console**: http://localhost:9090/h2-console

### H2 Database Console

To access the H2 database console for debugging:

1. Navigate to http://localhost:9090/h2-console
2. Use the following credentials:
   - **JDBC URL**: `jdbc:h2:mem:saradb`
   - **Username**: `sa`
   - **Password**: (leave blank)

## Running in VS Code

### Option 1: Using Maven Extension

1. Install the "Extension Pack for Java" in VS Code
2. Open the project folder in VS Code
3. Open the Command Palette (Ctrl+Shift+P or Cmd+Shift+P)
4. Type "Maven: Execute commands" and select it
5. Choose "spring-boot:run"

### Option 2: Using Integrated Terminal

1. Open the integrated terminal in VS Code (Ctrl+` or Cmd+`)
2. Run: `mvn spring-boot:run`

### Option 3: Using Spring Boot Dashboard

1. Install "Spring Boot Extension Pack" in VS Code
2. Open the Spring Boot Dashboard (View > Open View > Spring Boot Dashboard)
3. Click the "Run" icon next to the application

## Project Structure

```
SARA/
├── src/
│   ├── main/
│   │   ├── java/com/sara/resourcefinder/
│   │   │   ├── ResourceFinderApplication.java
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── ResourceController.java
│   │   │   │   ├── VolunteerController.java
│   │   │   │   └── DonorController.java
│   │   │   ├── model/
│   │   │   │   ├── Resource.java
│   │   │   │   ├── Volunteer.java
│   │   │   │   └── Donor.java
│   │   │   ├── repository/
│   │   │   │   ├── ResourceRepository.java
│   │   │   │   ├── VolunteerRepository.java
│   │   │   │   └── DonorRepository.java
│   │   │   └── service/
│   │   │       ├── ResourceService.java
│   │   │       ├── VolunteerService.java
│   │   │       └── DonorService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/css/
│   │       │   └── style.css
│   │       └── templates/
│   │           ├── index.html
│   │           ├── about.html
│   │           ├── resources/
│   │           │   ├── list.html
│   │           │   └── form.html
│   │           ├── volunteers/
│   │           │   ├── list.html
│   │           │   └── form.html
│   │           └── donors/
│   │               ├── list.html
│   │               └── form.html
│   └── test/
│       └── java/com/sara/resourcefinder/
│           └── ResourceFinderApplicationTests.java
├── pom.xml
└── README.md
```

## API Endpoints

### Resources
- `GET /resources` - List all resources
- `GET /resources/new` - Show create resource form
- `POST /resources/save` - Save a resource
- `GET /resources/edit/{id}` - Show edit resource form
- `GET /resources/delete/{id}` - Delete a resource

### Volunteers
- `GET /volunteers` - List all volunteers
- `GET /volunteers/new` - Show volunteer registration form
- `POST /volunteers/save` - Save a volunteer
- `GET /volunteers/edit/{id}` - Show edit volunteer form
- `GET /volunteers/delete/{id}` - Delete a volunteer

### Donors
- `GET /donors` - List all donors
- `GET /donors/new` - Show donor registration form
- `POST /donors/save` - Save a donor
- `GET /donors/edit/{id}` - Show edit donor form
- `GET /donors/delete/{id}` - Delete a donor

## Running Tests

```bash
mvn test
```

## Building for Production

```bash
mvn clean package
java -jar target/resource-finder-1.0.0.jar
```

## Configuration

The application uses an H2 in-memory database by default. Configuration can be modified in `src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=9090

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:saradb
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
```

## Features Overview

### Home Page
- Hero section with call-to-action buttons
- Feature cards showcasing main functionalities
- Navigation menu for easy access to all sections

### Resource Management
- Add new resources with details (name, description, category, quantity, location, contact)
- View all available resources in a table format
- Edit existing resources
- Delete resources
- Status tracking (Available, Requested, Delivered)

### Volunteer Management
- Register volunteers with personal information
- Track skills and availability
- View all registered volunteers
- Edit volunteer information
- Location-based filtering capability

### Donor Management
- Register donors (individuals or organizations)
- Track donation types (monetary, goods, services)
- View all registered donors
- Edit donor information
- Organization affiliation support

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available for use during disaster relief efforts.

## Support

For issues, questions, or contributions, please open an issue on GitHub.