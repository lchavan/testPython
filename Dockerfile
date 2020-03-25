FROM docker.repo1.uhc.com/providerprefs/base-image/redhat-openjdk:latest
FROM docker.repo1.uhc.com/providerprefs/base-image/fusemic001base:latest


ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0


USER root

EXPOSE 8080

ENV JAVA_VER=1.8.0

USER 0

RUN mkdir /ct

ADD /build/libs/service.jar /ct

WORKDIR /ct

# Make sure application.pid file can be created in the /ct directory by the jvm process
RUN chgrp -R 0 /ct && \
    chmod -R g=u /ct

CMD ["java","-jar","service.jar"]