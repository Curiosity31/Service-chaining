FROM openjdk:8-jdk-slim

# ENV: creazione di una variabile di ambiente
ENV APP_HOME /serviceregistry

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/serviceregistry.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","serviceregistry.jar"]