FROM openjdk:8-jdk-slim

# ENV: creazione di una variabile di ambiente
ENV APP_HOME /serviceB

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/serviceB.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","-jar","serviceB.jar"]