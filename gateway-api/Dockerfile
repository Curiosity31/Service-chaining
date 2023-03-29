FROM openjdk:8-jdk-slim

# ENV: creazione di una variabile di ambiente
ENV APP_HOME /gateway

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/gateway.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","-jar","gateway.jar"]