pipeline {
    agent any

    stages {

        stage('Build and Test') {
            steps {
                bat 'mvn clean package -DskipTests=false'
            }
        }

        stage('JaCoCo Report') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=task-management-api'
                }
            }
        }

        stage('Docker Image Build') {
            steps {
                bat 'docker build -t task-management-api .'
            }
        }
    }
}