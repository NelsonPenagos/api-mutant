FROM openjdk:8-jdk-alpine
COPY "./build/libs/mutant-0.0.1-SNAPSHOT.jar" "mutant.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","mutant.jar"]