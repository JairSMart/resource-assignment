# 1. Etapa de compilación con Maven + OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copiamos el pom.xml del subdirectorio correcto
COPY resource-assignment/pom.xml .

RUN mvn dependency:go-offline -B

# Copiamos el código fuente completo
COPY resource-assignment/src ./src

RUN mvn clean package -DskipTests -B

# 2. Etapa de ejecución con un JRE ligero
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Traemos el jar compilado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
