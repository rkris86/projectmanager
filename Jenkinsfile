pipeline {
    agent any
    tools {
        maven 'maven 3.6.2'
        jdk 'jdk1.8'
    }
    stages {
        stage('checkout') {

            steps {
                sh 'mvn --version'
                echo 'checkout done'
            }
        }
        stage('build') {
            steps {
                sh 'mvn install'
            }
        }

    }
}