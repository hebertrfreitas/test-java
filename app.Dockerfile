FROM openjdk:8-slim-buster

RUN apt update && apt install -y tzdata iputils-ping && \
    cp /usr/share/zoneinfo/Brazil/East /etc/localtime

RUN echo "America/Sao_Paulo" >  /etc/timezone

COPY . .

COPY target/*.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
