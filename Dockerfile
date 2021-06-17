
FROM openjdk:8
COPY "./build/libs/mutant-0.0.1-SNAPSHOT.jar" "api-mutant.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","api-mutant.jar"]