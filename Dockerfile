# Use OpenJDK 17 as base image
FROM openjdk:21

# Copy the built jar file into the image
COPY target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]