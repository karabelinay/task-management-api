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

        stage('Docker Run') {
            steps {
                bat 'docker rm -f task-management-api-container 2>nul || exit /b 0'
                bat 'docker run -d -p 8080:8080 --name task-management-api-container task-management-api'
            }
        }
    }
}