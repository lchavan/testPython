FROM docker.repo1.uhc.com/ct/ct-base-image:latest

MAINTAINER "Contracts Transformation DevOps Team <CT_DevOps-1_DL@ds.uhc.com>"
# For local debugging...only enabled in local sandbox testing
EXPOSE 8000
# Standard service endpoint
EXPOSE 8080

# Health check. Use Spring Boot Actuator's health endpoint to determine the health of this application.
# OpenShift uses its own mechanism for doing health checks, so this is purely cosmetic for when the image is run locally
HEALTHCHECK --interval=30s --timeout=30s \
CMD curl -f http://localhost:8080/health || exit 1

WORKDIR /opt

# JAR_FILE get substituted by Gradle at build-time to be the archive name
COPY $JAR_FILE .

USER root

# Make directory writeable for the root group
RUN chmod g+w . && \
# Create a symbolic link to a static name for run convenience.
  ln -s $JAR_FILE app.jar
