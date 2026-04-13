# Parte desde una imagen de Eclipse Temurin con JDK 17 y nombra esta etapa como build
FROM eclipse-temurin:17-jdk AS build-product

# Crea /app y lo fija como directorio de trabajo para las instrucciones siguientes
WORKDIR /app

# --- // app

# 1- Copia el wrapper de Maven del módulo ms-product al directorio actual (/app)
COPY ms-product/mvnw mvnw
# Copia la carpeta .mvn del módulo ms-product al directorio actual (/app)
COPY ms-product/.mvn .mvn

# Agrega permiso de ejecución al archivo mvnw para que pueda ejecutarse como script
RUN chmod +x mvnw

# Copia el módulo common-exception dentro de /app/common-exception
COPY common-exception common-exception

# Ejecuta Maven Wrapper sobre el pom del módulo common-exception indicado en 1-
# clean limpia el resultado previo
# install compila y registra el artefacto en el repositorio local de Maven dentro del contenedor
# -f indica qué pom.xml se debe usar
# -DskipTests omite las pruebas
RUN ./mvnw clean install -f common-exception/pom.xml -DskipTests

WORKDIR /app/ms-product
COPY ms-product/pom.xml pom.xml

COPY ms-product/src src
# compila y genera el .jar
RUN ../mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build-product /app/ms-product/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]