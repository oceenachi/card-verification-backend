#Start eith a base image containing java runtime
FROM openjdk:8-jdk-alpine

#Add maintainer info
LABEL maintainer="osinachiphillip@gmail.com"

#Add volume pointing to /tmp
VOLUME /tmp

#Make port 8080 available to the world outside this container
EXPOSE 8080

#The application's jar file
ARG JAR_FILE=target/card-verifier-0.0.1-SNAPSHOT.jar

#Add the applications jar to the container
COPY ${JAR_FILE} card-verifier.jar

#Run the jar file
ENTRYPOINT ["java", "-jar", "/card-verifier.jar"]