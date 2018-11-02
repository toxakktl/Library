FROM openjdk:8

EXPOSE 8080

ENV APP_HOME /usr/src/app

COPY target/LibraryDocker.jar $APP_HOME/app.jar

COPY docker/spring-boot/wait-for-it.sh /wait-for-it.sh
RUN chmod a+x /wait-for-it.sh

WORKDIR $APP_HOME

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar app.jar