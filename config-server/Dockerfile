FROM eclipse-temurin:17-jdk AS builder-config-server

WORKDIR /app
COPY config-server/.mvn .mvn
COPY config-server/mvnw mvnw


RUN chmod +x mvnw
COPY config-server/pom.xml pom.xml

RUN ./mvnw dependency:go-offline

COPY config-server/src src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder-config-server /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]