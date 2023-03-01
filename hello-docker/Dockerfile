FROM amazoncorretto:11-alpine
WORKDIR /app
COPY . /app/
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 9320
CMD ["java", "-jar", "/app.jar"]
