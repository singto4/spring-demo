def git_branch = "master"
def git_url = "https://github.com/singto4/spring-demo.git"
def project_name = "demo"

pipeline {
  agent none
  stages {
  	stage('Maven Install') {
    	agent {
      	docker {
        	image 'maven:3.5.0'
        }
    }
    stage("Pull Code From Master Branch") {
      git branch: "$git_branch", url: "$git_url"
    }
    stage("Build Jar") {
      sh 'mvn clean package'
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
