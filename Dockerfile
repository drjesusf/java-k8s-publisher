# Etapa 1: Build
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src ./src

# Construir el proyecto
RUN mvn clean package -DskipTests

# Etapa 2: Run
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el JAR generado desde la etapa de build
COPY --from=build /app/target/*.jar k8spublisher.jar

# Exponer el puerto de la aplicación
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "k8spublisher.jar"]
