FROM openjdk:8-jdk-alpine

# Copy the packaged JAR file into the container at /app
COPY target/sqs-example-0.0.1-SNAPSHOT.jar app.jar

# Define the command to run your application
ENTRYPOINT ["java","-jar","/app.jar"]




