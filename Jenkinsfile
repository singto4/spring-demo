def git_branch = "master"
def git_url = "https://github.com/singto4/spring-demo.git"
def project_name = "demo"

pipeline {
  agent {
    docker { name 'maven', image 'maven:3.6.3-jdk-8' }
  }
  stages {
    stage("Prepare configuration") {
      steps {
        script {
          container("maven") {
            stage("Update Custom Maven Lib") {
              git branch: "$git_branch_lib", credentialsId: "$git_credentials_id", url: "https://github.com/corp-ais/ebiz-microservice-lib.git"
              sh "mvn clean install -Dmaven.test.skip"
              cleanWs()
            }
            stage("Pull Code From Master Branch") {
              git branch: "$git_branch", credentialsId: "$git_credentials_id", url: "$git_url"
            }
            stage("Build Jar") {
              sh "mvn clean package -am -pl billing-detail -Dmaven.test.skip"
            }
          }
        }
      }
    }

    stage("Build image") {
      steps {
        script {
          container("docker") {
            sh "docker -v"
            sh "docker build -t ${project_name}:jenkins_build -t ${project_name}:jenkins_build_latest ."
          }
        }
      }
    }

    }
  
}
