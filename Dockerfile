FROM openjdk:8-jdk-alpine
RUN mkdir -p /app/
RUN mkdir -p /Nas/
EXPOSE 8080
COPY target/api-0.0.1-SNAPSHOT.jar /app
COPY Nas/file_test.txt /Nas
ENTRYPOINT [ "java", "-jar", "/app/api-0.0.1-SNAPSHOT.jar" ]
