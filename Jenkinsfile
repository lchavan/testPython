#!/usr/bin/env groovy
import com.optum.jenkins.pipeline.library.utils.Constants

@Library("com.optum.jenkins.pipeline.library@v0.2.2") _


pipeline {
  agent none
  environment {
    GIT_CREDENTIALS_ID = ''
    TECH_USER_ID = ''
    OPENSHIFT_CREDENTIALS_NONPROD_ID = ''
    DOCKER_CREDENTIALS_ID = ''
    DOCKER_HOSTNAME = 'docker.repo1.uhc.com'
    DOCKER_NAMESPACE = 'ct'
    DOCKER_REPO = '<repo-name>'
    DOCKER_DEV_TAG= 'latest'
    OC_URL= 'https://ocp-ctc-dmz-nonprod.optum.com'
    OC_DEV_PROJECT= 'polaris-ct'
    OC_SERVICE_NAME = '<servicename>'

  }

  stages {
    stage('Gradle Build') {
      agent { label 'docker-maven-slave' }
      steps {
        glGradleBuild taskName: "clean bootJar", runSonarqube: false
        stash 'artifacts'
      }
    }


    stage('Build/Deploy Dev Docker Image') {
      agent { label 'docker-maven-slave' }
      steps {
        echo 'Docker Build Dev'
        unstash 'artifacts'
        glDockerImageBuildPush tag: "${env.DOCKER_HOSTNAME}/${env.DOCKER_NAMESPACE}/${env.DOCKER_REPO}:${env.DOCKER_DEV_TAG}",
                extraBuildOptions: "--force-rm --no-cache",
                dockerHost: "${env.DOCKER_HOSTNAME}",
                dockerCredentialsId: "${env.DOCKER_CREDENTIALS_ID}"
      }
    }

    stage('Deploy To OCP DEV') {
      agent { label 'docker-maven-slave' }
      steps {
        echo 'Deploy to Dev'
        glOpenshiftDeploy credentials: "$env.OPENSHIFT_CREDENTIALS_NONPROD_ID", ocpUrl: "$env.OC_URL", project: "$env.OC_DEV_PROJECT", serviceName: "$env.OC_SERVICE_NAME", dockerImage: "${env.DOCKER_HOSTNAME}/${env.DOCKER_NAMESPACE}/${env.DOCKER_REPO}", tag: "${env.DOCKER_DEV_TAG}", port: '8080'
      }
    }
  }
  post {
    always {
      echo 'This will always run'
      emailext body: "Build URL: ${BUILD_URL}",
              subject: "$currentBuild.currentResult-$JOB_NAME",
              to: 'nelanthe.vithanage@optum.com'
    }
    success {
      echo 'This will run only if successful'
    }
    failure {
      echo 'This will run only if failed'
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
  }
}
