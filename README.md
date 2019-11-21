# Spring-Boot microservice base application template (v5)
 This repository contains the base setup for a new microservice with base configurations 
 for Spring-Boot, Gradle, Jenkins and Docker. 
 
 Spring-Boot defines a default architecture for the application with stateless services and models
 to encapsulate the application state. Example classes for the architecture are included in this 
 template.
 
 This template is named **v5** because it is compatible with Gradle version 5.

### Java SDK prerequisites
This template assumes that Java 11 SDK will be used. You may install Java 11 SDK from AppStore. It is possible to have Java 8 installed side by side.

Gradlew script uses JAVA_HOME to find the java binary to use so make sure your JAVA_HOME is pointing the corresponding SDK directory when using Gradle command line.

Make sure your IntelliJ IDEA installation has Java 11 SDK added to Global SDK and make sure that Lombok plugin in installed.

### Common Files and Folders:
* **build.gradle** – Project build script
* **gradle.properties** – Shared properties for the whole project, e.g. library version  numbers
* **settings.gradle** – Project build settings, subprojects are included from this configuration, add your subprojects there
* **src/** – Default source code directory for code and resources
* **src/main/resources/application.yml** – Service configuration file, used to externalize properties for the service in YAML format
* **src/main/java/com/optum/ct/_\<service name\>_/Application.java** – Spring boot application configuration
* **src/test/java** and **src/test/groovy** - Unit tests
* **src/integration-test/java** and **src/integration-test/groovy** - Integration tests
* **src/acceptance-test** - Acceptance tests
* **src/main/docker** - Docker build files
 
### Default Java package layout:
* **com.optum.ct._\<service name\>_.config** – externalized configuration classes (@ConfigurationProperties and @Configuration)
* **com.optum.ct._\<service name\>_.controller** – REST controller classes
* **com.optum.ct._\<service name\>_.service** – Service (business) logic
* **com.optum.ct._\<service name\>_.model** – Model classes
* **com.optum.ct._\<service name\>_.repository** - Repository interfaces
* **com.optum.ct._\<service name\>_.util** - Utility classes

## Creating IntelliJ IDEA project

* In IntelliJ go to File>New>Project from Existing Sources..
* Select the project directory
* Keep "(*) Import project from external model" checked and selected to Gradle. Click Finish

Note that we choose not to include Gradle idea task in the template but you are free to add it if you need it yourself.

A properly configured Gradle project should be created at this time. 

## Building the App

To run a Gradle build, simply run the following command:

```
./gradlew build
```

Including the `clean` task will also remove previous build files and artifacts.

To run the application from command line, run:

```
./gradlew bootRun
```

or, alternately,

```
java -jar build/libs/<application name>.jar
```

## Spring Profiles

Spring provides a mechanism to run an application in a specific profile, e.g. development or production. Profiles may be
defined in the `application.yml` file found in `src/main/resources`. Profiles inherit from a single 'default' profile,
if defined.

To run in a different profile, run the application with the parameter `-Dspring.profiles.active=<profile>` or `-Denv=<profile>`,
e.g.:

```
./gradlew -Dspring.profiles.active=dev bootRun
```

## Acceptance Tests

To run acceptance tests, execute the following command:

```
./gradlew acceptanceTest
```

## Building and Running As a Docker Container

To build a Docker image, run the command:

```
./gradlew docker
```

This will create a new docker image, under the name `docker.optum.com/ct_devops/<name>:<version>`

This container may be run normally, using the standard command:

```
docker run -p 8080:8080 docker.optum.com/ct_devops/<name>:<version>
```

Any parameters passed into the `run` command will be executed as-is instead of running the app.

## Building and Publishing Releases

To build a release, do a standard

```
./gradlew build
```

This will build your application / library artifact, along with source and javadoc jars.

### Publishing to Local Maven repository

To publish to your local Maven repository, run the Gradle task:

```
./gradlew publishToMavenLocal
```

This will install your artifacts locally, so they are available across your projects.

### Publishing to Artifactory

To publish to Optum Artifactory, run the Gradle task:

```
./gradlew -Partifactory_user=<username> -Partifactory_password=<password> artifactoryPublish
```

You will either need to supply the `artifactory_user` and `artifactory_password` arguments in the command line,
or provide them in the `gradle.properties` file:

```
artifactory_user=<username>
artifactory_password=<password>
```
