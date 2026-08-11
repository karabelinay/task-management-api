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
    }
}