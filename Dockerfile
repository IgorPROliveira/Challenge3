    FROM openjdk:17
    ADD home/user/.local/tmp/buildkit-mount2019890937/target*.jar app.jar
    WORKDIR /appp
    EXPOSE 8080
    COPY target/*.jar /appp/app.jar
    ENTRYPOINT ["java", "-jar", "/app.jar"]

