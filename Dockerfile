FROM maven:3.9.8 AS build

# Set the working directory & Copy the project's pom.xml and source code into the container
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Run the Maven build to create the JAR file
RUN mvn clean package

# Use openJDk to run the application
FROM openjdk:17-jdk

WORKDIR /app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /app/target/rock-paper-scissors-1.0-SNAPSHOT.jar /app/app.jar
# Define the command to run the JAR file
CMD ["java", "-jar", "/app/app.jar"]