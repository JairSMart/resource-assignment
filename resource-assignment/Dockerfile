# 1. Etapa de compilación con Maven + OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copiamos sólo pom.xml primero para aprovechar la caché de capas
COPY pom.xml .

# Descargamos dependencias sin compilar aún
RUN mvn dependency:go-offline -B

# Copiamos el resto del código y compilamos el jar
COPY src ./src
RUN mvn clean package -DskipTests -B

# 2. Etapa de ejecución con un JRE liviano
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Traemos el jar construido en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto de la aplicación
EXPOSE 8080

# Comando por defecto
ENTRYPOINT ["java","-jar","/app/app.jar"]
