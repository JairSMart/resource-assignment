# 1. Etapa de compilación con Maven + OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copiamos el pom.xml que está en weather-alert/
COPY weather-alert/pom.xml .

RUN mvn dependency:go-offline -B

# Copiamos todo el código fuente
COPY weather-alert/src ./src

RUN mvn clean package -DskipTests -B

# 2. Etapa de ejecución con un JRE liviano
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Traemos el jar construido
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
