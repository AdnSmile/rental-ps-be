FROM openjdk:17.0.1-jdk

COPY target/rental-ps-be-0.0.1-SNAPSHOT.jar /app/application.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/application.jar"]