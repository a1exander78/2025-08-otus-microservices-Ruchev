FROM bellsoft/liberica-openjdk-alpine-musl:17
COPY /target/api_gateway-0.0.1-SNAPSHOT.jar /app/crud.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app/crud.jar"]
