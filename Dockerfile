# Gunakan base image Java
FROM openjdk:17-jdk-slim

# Set working directory di dalam container
WORKDIR /app

# Copy file JAR dari Maven build ke dalam container
COPY target/*.jar app.jar

# Expose port sesuai port aplikasi Spring Boot kamu
EXPOSE 8080

# Perintah untuk menjalankan aplikasi
ENTRYPOINT ["java", "-jar", "app.jar"]
