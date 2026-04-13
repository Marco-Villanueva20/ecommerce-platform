FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# 1. Copiamos el wrapper desde el microservicio a la raíz de /app para usarlo globalmente
COPY ms-customer/mvnw .
COPY ms-customer/.mvn .mvn
RUN chmod +x mvnw

# 2. Copiamos e INSTALAMOS la librería común en el repositorio local de la imagen
COPY common-exception common-exception
RUN ./mvnw clean install -f common-exception/pom.xml -DskipTests

# 3. Preparamos el microservicio ms-customer
# Usamos una subcarpeta para no mezclar archivos
WORKDIR /app/ms-customer
COPY ms-customer/pom.xml .
# Usamos el mvnw que está un nivel arriba (../mvnw)
RUN ../mvnw dependency:go-offline || true

# 4. Copiamos el código fuente y empaquetamos
COPY ms-customer/src src
RUN ../mvnw clean package -DskipTests

# --- Etapa final de ejecución ---
FROM eclipse-temurin:17-jre
WORKDIR /app

# Buscamos el jar generado en la etapa de build
COPY --from=build /app/ms-customer/target/*.jar app.jar

EXPOSE 8080

# Asegúrate de que no haya espacios raros en los argumentos
ENTRYPOINT ["java", "-jar", "app.jar"]