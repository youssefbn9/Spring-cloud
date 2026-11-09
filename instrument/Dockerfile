FROM eclipse-temurin:21-jre-alpine

RUN apk add --no-cache curl && \
    addgroup -S appgroup && \
    adduser -S appuser -G appgroup

WORKDIR /app

ARG JAR_FILE=target/instrument-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

RUN chown -R appuser:appgroup /app

USER appuser:appgroup

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
