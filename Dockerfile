FROM openjdk:8-jdk-alpine
COPY /build/libs/automotive-vehicle-0.0.1-SNAPSHOT.jar automotive-vehicle.jar
CMD ["java","-jar","/automotive-vehicle.jar"]