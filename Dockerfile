FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/spring-docker-avaliacao.jar
WORDIR /app
ENTRYPOINT java -jar spring-docker-avaliacao.jar 