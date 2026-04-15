FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN javac -d . src/main/java/app/App.java

CMD ["java", "app.App"]