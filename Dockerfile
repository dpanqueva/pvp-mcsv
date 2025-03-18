# Etapa 1: Construir el archivo JAR con Maven
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

# Copiar el código fuente y construir el JAR
COPY . /app
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el archivo JAR desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Definir las variables de entorno para la base de datos
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}

# Exponer el puerto
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]