# TestingGitHubActions

A full-stack web application with Vue.js frontend and Spring Boot backend, featuring Docker containerization and GitHub Actions CI/CD pipeline.

## Project Structure

```
├── frontend/          # Vue.js frontend application
│   ├── src/
│   │   ├── components/
│   │   ├── views/
│   │   ├── router/
│   │   ├── App.vue
│   │   └── main.js
│   ├── public/
│   ├── package.json
│   └── Dockerfile
├── backend/           # Spring Boot backend application
│   ├── src/
│   │   ├── main/java/com/example/demo/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   ├── pom.xml
│   └── Dockerfile
├── .github/workflows/ # GitHub Actions CI/CD pipeline
├── docker-compose.yml # Docker Compose configuration
└── README.md
```

## Technologies Used

### Frontend
- **Vue.js 3** - Progressive JavaScript framework
- **Vue Router** - Client-side routing
- **Axios** - HTTP client for API calls
- **Vue CLI** - Development tooling

### Backend
- **Spring Boot** - Java framework for building web applications
- **Spring Web** - RESTful web services
- **Spring Data JPA** - Data persistence layer
- **H2 Database** - In-memory database for development
- **Maven** - Build tool and dependency management

### DevOps
- **Docker** - Containerization
- **Docker Compose** - Multi-container orchestration
- **GitHub Actions** - CI/CD pipeline
- **Nginx** - Web server for frontend production build

## Getting Started

### Prerequisites
- Node.js 18+ and npm
- Java 17+
- Docker and Docker Compose (optional)

### Running Locally

#### Backend
```bash
cd backend
./mvnw spring-boot:run
```
The backend will be available at `http://localhost:8081`

API endpoints:
- `GET /api/hello` - Test endpoint
- `GET /api/health` - Health check

#### Frontend
```bash
cd frontend
npm install
npm run serve
```
The frontend will be available at `http://localhost:8080`

### Running with Docker

Build and run both services:
```bash
docker-compose up --build
```

- Frontend: `http://localhost:8080`
- Backend: `http://localhost:8081`

## Development

### Frontend Development
```bash
cd frontend
npm install          # Install dependencies
npm run serve        # Start development server
npm run build        # Build for production
npm run lint         # Run linter
```

### Backend Development
```bash
cd backend
./mvnw clean install      # Build project
./mvnw test               # Run tests
./mvnw spring-boot:run    # Start development server
```

## CI/CD Pipeline

The project includes a GitHub Actions workflow that:

1. **Tests** - Runs unit tests for both frontend and backend
2. **Build** - Creates production builds using Docker
3. **Integration Tests** - Tests the full application stack

The pipeline is triggered on:
- Push to `main` or `develop` branches
- Pull requests to `main` branch

## API Documentation

### Available Endpoints

#### GET /api/hello
Returns a welcome message from the backend.

**Response:**
```json
{
  "message": "Hello from Spring Boot!",
  "status": "success"
}
```

#### GET /api/health
Health check endpoint for monitoring.

**Response:**
```json
{
  "status": "UP",
  "service": "Spring Boot Backend"
}
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.
Please Ignore Me!
