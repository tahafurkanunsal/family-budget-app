FROM openjdk:17-jdk-slim
EXPOSE 8081
ARG JAR_FILE=target/family-budget-app-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} family-budget-app.jar
ENTRYPOINT ["java","-jar","family-budget-app.jar"]