FROM openjdk:8-jdk-slim

# ENV: creazione di una variabile di ambiente
ENV APP_HOME /serviceA

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/serviceA.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","serviceA.jar"]