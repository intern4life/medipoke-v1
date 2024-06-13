FROM openjdk:17-jdk-alpine
MAINTAINER your-name
COPY target/bruderichhangnueg/medipoke-v1-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]