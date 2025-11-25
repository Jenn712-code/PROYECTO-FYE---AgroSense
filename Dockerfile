# Stage 1: build
FROM maven:3.9.2-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: runtime
FROM amazoncorretto:17
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 2023
ENTRYPOINT ["java", "-jar", "app.jar"]
