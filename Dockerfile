FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean build -x test

EXPOSE 8080

ENTRYPOINT ["java","-jar","build/libs/arenda-0.0.1-SNAPSHOT.jar"]
