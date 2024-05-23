# Imagen base
FROM openjdk:11.0.16

# Path general
WORKDIR /api

# Argumento para el JAR
ARG JAR_FILE=target/*.jar

# Copiar el JAR al contenedor
COPY ${JAR_FILE} app.jar

# Argumento para el archivo de propiedades
ARG PROP_FILE=src/main/resources/application.properties

# Copiar el archivo de propiedades
COPY ${PROP_FILE} prop.properties

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java","-jar","/api/app.jar", "--spring.config.location=file:/api/prop.properties"]
