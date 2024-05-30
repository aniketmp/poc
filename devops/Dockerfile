FROM openjdk:17
COPY target/poc.jar /home/app/poc.jar
WORKDIR /home/app
EXPOSE 8080
CMD ["java", "-jar", "poc.jar"]