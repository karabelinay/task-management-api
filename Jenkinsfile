pipeline {
    agent any

    stages {

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
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
                    bat 'mvn sonar:sonar -Dsonar.projectKey=task-management-api'
                }
            }
        }
    }
}
