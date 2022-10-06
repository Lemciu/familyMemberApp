FROM openjdk:11

COPY target/Inteca2-0.0.1-SNAPSHOT.jar Inteca2-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/Inteca2-0.0.1-SNAPSHOT.jar"]