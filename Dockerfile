# syntax=docker/dockerfile:1
FROM openjdk:8
COPY target/poc.jar /home/app/poc.jar
WORKDIR /home/app
EXPOSE 8080
CMD ["java", "-jar", "poc.jar"]