FROM openjdk:17

COPY target/tfg-0.0.1-SNAPSHOT.jar /tfg.jar

CMD ["java", "-jar", "/tfg.jar"]