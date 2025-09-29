
# Estágio 1: Build com Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .


COPY src ./src

RUN mvn package -DskipTests

# Estágio 2: Imagem final com JRE
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Variáveis de ambiente que o Render pode sobrescrever
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://ep-restless-art-adic3kzr-pooler.c-2.us-east-1.aws.neon.tech:5432/neondb?sslmode=require
ENV SPRING_DATASOURCE_USERNAME=neondb_owner
ENV SPRING_DATASOURCE_PASSWORD=npg_yf2crBEFlh1K
ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java", "-jar", "app.jar"]
