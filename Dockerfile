# Stage 1: Build the app
FROM maven:3.9.5-eclipse-temurin-17-alpine as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /app/target/attendance-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
