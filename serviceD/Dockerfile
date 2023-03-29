FROM openjdk:8-jdk-slim

# ENV: creazione di una variabile di ambiente
ENV APP_HOME /serviceD

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/serviceD.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","-jar","serviceD.jar"]