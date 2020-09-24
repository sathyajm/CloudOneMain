ARG BASE_IMAGE=docker-ngdc.repo.east1.ncloud.netapp.com/redhat-openjdk-18/openjdk18-openshift:latest
ARG JAR

FROM ${BASE_IMAGE}
ARG JAR
ENV JAVA_APP_JAR=${HOME}/app.jar
COPY ${JAR} app.jar