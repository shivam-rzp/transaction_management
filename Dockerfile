FROM maven:3.8.5-openjdk-17 AS build
EXPOSE 8080
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B -X
COPY src ./src
RUN mvn package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ADD src/main/resources/application-dev.properties application-dev.properties
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/application-dev.properties"]