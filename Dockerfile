FROM openjdk:21-jdk
LABEL authors="ka9mal6t"

WORKDIR /app

COPY app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]