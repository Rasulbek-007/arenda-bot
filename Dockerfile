FROM gradle:9.3.0-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/build/libs/arenda-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
