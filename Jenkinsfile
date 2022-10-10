pipeline {
    agent { label 'Java17' }
    stages {
        stage('build') {
            steps {
                git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                sh 'mvn -version'
                sh 'mvn clean install'
            }
        }
    }
}