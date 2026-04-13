FROM eclipse-temurin:17-jdk AS builder-discovery

WORKDIR /app


COPY discovery-server/.mvn .mvn
COPY discovery-server/mvnw mvnw

RUN chmod +x mvnw

COPY discovery-server/pom.xml pom.xml
RUN ./mvnw dependency:go-offline

COPY discovery-server/src src
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder-discovery /app/target/*.jar app.jar
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]