FROM openjdk:17-jdk-alpine
WORKDIR /ssf
ADD target/SpringSecurity-0.0.1-SNAPSHOT.jar ssf.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "/ssf/ssf.jar"]