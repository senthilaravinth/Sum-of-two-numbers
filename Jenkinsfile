pipeline {
    agent any

    tools {
        jdk 'JDK17'   // Make sure this is configured in Jenkins
    }

    environment {
        DOCKER_USERNAME = "23mis0086"
        IMAGE_NAME = "java-add-app"
        IMAGE_TAG = "latest"
    }

    stages {

        stage('Clone Repository') {
            steps {
                checkout scm
            }
        }

        stage('Build Java Program') {
            steps {
                bat 'javac app\\App.java'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat '"C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker.exe" build -t %DOCKER_USERNAME%/%IMAGE_NAME%:%IMAGE_TAG% .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                script {
                    withCredentials([usernamePassword(
                        credentialsId: 'dockerhub-cred',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )]) {
                        bat '''
                        echo %DOCKER_PASS% | "C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker.exe" login -u %DOCKER_USER% --password-stdin
                        '''
                    }
                }
            }
        }

        stage('Push Image to DockerHub') {
            steps {
                bat '"C:\\Program Files\\Docker\\Docker\\resources\\bin\\docker.exe" push %DOCKER_USERNAME%/%IMAGE_NAME%:%IMAGE_TAG%'
            }
        }

        stage('Build Successful') {
            steps {
                echo 'Java application Docker image pushed successfully!'
            }
        }
    }
}