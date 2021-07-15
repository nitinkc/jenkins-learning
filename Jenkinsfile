pipeline {
    agent {
       label 'agentId' //The id of the slave/agent where the build should be executed, if it doesn't matter use "agent any" instead.
    }
    stages {
            stage('Checkout') {
                steps { //Checking out the repo
                    checkout changelog: true, poll: true, scm: [$class: 'GitSCM', branches: [[name: '*/master']], browser: [$class: 'BitbucketWeb', repoUrl: 'https://web.com/blah'], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git', url: 'git@github.com:nitinkc/devops-learning.git']]]
                }
            }
    }

}
/*
node {
   def mvnHome
   stage('Prepare') {
      git url: 'https://github.com/nitinkc/devops-learning.git', branch: 'develop'
      mvnHome = tool 'maven'
   }
   stage('Build') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Unit Test') {
      junit '**//*
target/surefire-reports/TEST-*.xml'
      archive 'target */
/*.jar'
   }
   stage('Integration Test') {
     if (isUnix()) {
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"
     } else {
        bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)
     }
   }
   stage('Sonar') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' sonar:sonar"
      } else {
         bat(/"${mvnHome}\bin\mvn" sonar:sonar/)
      }
   }
   stage('Deploy') {
       sh 'curl -u jenkins:jenkins -T target */
/**.jar "http://localhost:8080/manager/text/deploy?path=/devops&update=true"'
   }
   stage("Smoke Test"){
       sh "curl --retry-delay 10 --retry 5 http://localhost:8080/devops"
   }
} */
