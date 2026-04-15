FROM openjdk:17

WORKDIR /app

# Copy all files
COPY . .

# Compile Java file from src path
RUN javac -d . src/main/java/app/App.java

# Run using package name
CMD ["java", "app.App"]