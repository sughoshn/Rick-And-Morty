FROM openjdk:20
MAINTAINER Sughosh N Murthy
COPY target/microservice-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]