FROM openjdk:17

WORKDIR /app

# Copy entire project
COPY . .

# Compile
RUN javac app/App.java

# Run
CMD ["java", "app.App"]