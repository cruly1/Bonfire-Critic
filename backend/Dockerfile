# Build stage
FROM maven:3.8.1-openjdk-17 AS build

WORKDIR /project

COPY pom.xml .

COPY src/ /project/src

RUN mvn clean install #-DskipTests=false

# Run stage
FROM eclipse-temurin:17-jre-alpine

RUN mkdir /app

COPY --from=build /project/target/*.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-cp", "/app/app.jar", "-Dloader.path=/app/", "-Dloader.main=hu.unideb.inf.thesis.bonfirecritic.Application", "org.springframework.boot.loader.launch.JarLauncher"]
