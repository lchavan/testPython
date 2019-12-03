FROM docker.repo1.uhc.com/providerprefs/base-image/redhat-openjdk:latest
FROM docker.repo1.uhc.com/providerprefs/base-image/fusemic001base:latest


ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0


USER root

EXPOSE 8080

ENV JAVA_VER=1.8.0

USER 0

RUN mkdir /ct

ADD /build/libs/<servicename>-0.0.1-SNAPSHOT.jar /ct

WORKDIR /ct

RUN chown -R 1001:1001 /ct

USER 1001

CMD ["java","-jar","<servicename>-0.0.1-SNAPSHOT.jar"]