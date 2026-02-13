# spring-react-redux
POC client/server application with a frontend based on React and Redux and a backend based on Spring.

## Tech Stack

### Backend
- **Spring Boot**: 3.5.10
- **Java**: 25
- **Gradle**: 9.3.1

### Frontend
- **React**: 18.3.1
- **Redux**: 5.0.1
- **React-Redux**: 9.1.2

## Requirements

- Java 25 or higher
- Node.js 18 or higher
- npm 8 or higher

## Usage

### Start backend server

```bash
./gradlew bootRun
```

The backend will be available at `http://localhost:8080/app`

### Start frontend application

```bash
cd app/
npm install
npm start
```

The frontend will be available at `http://localhost:3000`

## API Endpoints

- `GET /app/api/v1/hello?name=<name>` - Returns a greeting message
- `GET /app/api/v1/test?name=<name>` - Tests error handling
- `GET /app/api/v1/time` - Returns current server time in JSON format

## Testing

### Backend Tests
```bash
./gradlew test
```

### Frontend Tests
```bash
cd app/
npm test
```

### Build Production
```bash
# Backend
./gradlew build

# Frontend
cd app/
npm run build
```

## Recent Updates

See [TECH_STACK_UPDATE.md](TECH_STACK_UPDATE.md) for details on the recent comprehensive tech stack update to the latest stable versions.
