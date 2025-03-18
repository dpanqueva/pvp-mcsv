# Usa una imagen base de OpenJDK
FROM eclipse-temurin:21-jdk

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Maven al contenedor
COPY target/*.jar app.jar

# Definir las variables de entorno para la base de datos
ENV DB_USERNAME=${DB_USERNAME}
ENV DB_PASSWORD=${DB_PASSWORD}

# Expone el puerto en el que corre la aplicación Spring Boot
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
