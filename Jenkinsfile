def git_branch = "master"
def git_url = "https://github.com/singto4/spring-demo.git"
def project_name = "demo"

pipeline {
  agent {
    kubernetes {
            yaml """
apiVersion: v1
kind: Pod
spec:
  containers:
  - name: maven
    image: maven:3.6.3-jdk-8
    command:
    - cat
    tty: true
  - name: docker-daemon
    image: docker:19.03.1-dind
    alwaysPullImage: false
    securityContext:
      privileged: true
    env:
    - name: DOCKER_TLS_CERTDIR
      value: ""
    volumeMounts:
    - name: docker-volume
      mountPath: /var/lib/docker
  - name: docker
    image: docker:20.10.23
    command:
    - cat
    tty: true
    env:
    - name: DOCKER_HOST
      value: tcp://localhost:2375
  volumes:
    - name: docker-volume
      emptyDir: {}
"""
    }
  }
  stages {
    stage("Prepare configuration") {
      steps {
        script {
          container("maven") {
            stage("Pull Code From Master Branch") {
              git branch: "$git_branch", url: "$git_url"
            }
            stage("Build Jar") {
              sh "mvn clean package"
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
