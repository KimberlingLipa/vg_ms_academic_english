FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/vg-ms-academic-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]