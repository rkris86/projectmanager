FROM openjdk:8-jre-alpine

MAINTAINER Projectmanger Team

WORKDIR /usr/local/bin

ADD target/projectmanager-0.0.1.jar projectmanager-0.0.1.jar

EXPOSE 8081

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","projectmanager-0.0.1.jar","--server.port=8081"]

