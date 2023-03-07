def git_branch = "master"
def git_url = "https://github.com/singto4/spring-demo.git"
def project_name = "demo"

pipeline {
  agent {
      docker {
          image 'maven:3.9.0-eclipse-temurin-11' 
          args '-v /root/.m2:/root/.m2' 
      }
  }
  stages {
    stage("mvn") {
      steps("Pull Code From Master Branch") {
        git branch: "$git_branch", url: "$git_url"
      }
      steps("Build Jar") {
        sh 'mvn clean package'
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
