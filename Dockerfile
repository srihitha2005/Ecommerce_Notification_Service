# Stage 1: Build the application
FROM gradle:8.4-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

# Stage 2: Run the application
# Using eclipse-temurin as the maintained alternative to the deprecated openjdk image
FROM eclipse-temurin:17-jre-jammy
EXPOSE 8085
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]