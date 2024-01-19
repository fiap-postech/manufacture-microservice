FROM --platform=linux/amd64 openjdk:17-alpine

WORKDIR /service

COPY ./manufacture-service.jar ./manufacture-service.jar

RUN /bin/sh -c 'touch /service/manufacture-service.jar'

CMD ["java", "-jar", "manufacture-service.jar"]