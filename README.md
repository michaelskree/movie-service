# Movie Service
## Description
Movie Service is a REST API for storing and editing a movie collection.
## Requirements
- Java
- Docker
- Docker Compose
## Getting Started
Clone this repository and `cd` into the root directory. Execute the following command to start a Postgres instance on localhost port 5432:
```
$ docker-compose up -d
```
Database connection information is passed to the service via environment variables. Export the following variables in your shell:
```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/movie_service
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=abc123
```
Finally, execute the following command to compile and run the service:
```
$ ./gradlew bootRun
```
The service will now be accessible at http://localhost:8080
