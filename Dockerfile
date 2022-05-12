FROM openjdk:11

  EXPOSE 8080

#  COPY /target/country-service-ms 0.0.1-SNAPSHOT.jar app/country-service.jar
  WORKDIR /usr/src/app
  RUN javac Main.java
  CMD ["java", "Main"]