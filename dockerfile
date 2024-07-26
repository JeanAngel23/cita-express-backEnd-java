FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/citaexpress.jar /app/citaexpress.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/citaexpress.jar"]