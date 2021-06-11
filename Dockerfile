FROM openjdk:11
COPY build/libs/movie-service.jar /app/movie-service.jar
CMD ["java", "-jar", "/app/movie-service.jar"]
