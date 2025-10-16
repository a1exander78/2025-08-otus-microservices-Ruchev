FROM bellsoft/liberica-openjdk-alpine-musl:17
COPY /target/k8s-0.0.1-SNAPSHOT.jar /app/health.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "/app/health.jar"]
