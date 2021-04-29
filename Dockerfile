FROM gcr.io/distroless/java:11 as app
COPY ./target/*.jar /app/app.jar
WORKDIR /app
CMD ["app.jar"]
