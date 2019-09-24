pipeline {
    agent any
    tools {
        maven 'maven 3.6.2'
        jdk 'jdk1.8'
    }
    stages {
        stage('checkout') {
            agent any
            steps {
                echo 'checkout'
                sh 'mvn --version'
            }
        }
        stage('compile') {
            agent any
            steps {
                echo 'mvn clean compile'
            }
        }
        stage('test') {
                    agent any
                    steps {
                        echo 'mvn test'
                    }
         }
         stage('package') {
         agent any
            steps {
                echo 'mvn package'
            }
        }
    }
}