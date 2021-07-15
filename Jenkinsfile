#!groovy
pipeline {
    agent any

    stages {
        stage('Prepare & Checkout') {
            steps { //Checking out the repo
                checkout changelog: true,
                        poll: true,
                        scm: [$class                           : 'GitSCM', branches: [[name: '*/develop']],
                              //browser: [$class: 'Github', repoUrl: 'https://github.com/nitinkc'],
                              doGenerateSubmoduleConfigurations: false,
                              extensions                       : [[$class: 'CleanBeforeCheckout'], [$class: 'RelativeTargetDirectory', relativeTargetDir: 'targetDir']],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[credentialsId: 'git', url: 'https://github.com/nitinkc/devops-learning.git']]]
            }
        }

        stage('Clean & Build') {
            steps{
                script{
                    try{
                        sh './gradlew clean build'
                    } finally {

                    }
                }
            }
        }

        stage('Unit & Integration Tests') {
            steps {
                script {
                    try {
                       // sh './gradlew clean test --no-daemon' //run a gradle task
                    } finally {
                        //junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
            }
        }

        stage('Publish Artifact to Jfrog Artifactory') {
            steps {
                sh 'echo "Publishing to JFrog Artifactory"'
                //sh './gradlew publish --no-daemon'
                sh './gradlew artifactoryPublish --no-daemon'

            }
        }
    }
    /*post {
        always { //Send an email to the person that broke the build
            step([$class                  : 'Mailer',
                  notifyEveryUnstableBuild: true,
                  recipients              : [emailextrecipients([[$class: 'CulpritsRecipientProvider'], [$class: 'RequesterRecipientProvider']])].join(' ')])
        }
    }*/
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
