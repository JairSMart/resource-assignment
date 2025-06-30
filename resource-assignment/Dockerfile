# 1. Etapa de compilación con Maven
FROM maven:3.9.4-jdk-17-slim AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# 2. Etapa de runtime con OpenJDK
FROM openjdk:17-slim

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
