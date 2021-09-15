pipeline {
    agent { label 'Java11' }
    stages {
        stage('build') {
            steps {
                git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                sh 'mvn --version'
                sh 'mvn clean install -pl Java6,Java7,Java8,Java9,Java10'
            }
        }
        stage('Java12') {
            agent{ label 'Java12' }
            steps {
                git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                sh 'mvn --version'
                sh 'mvn clean install -pl Java12'
            }
        }
        stage('Java13') {
            steps {
                git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                sh 'mvn clean install -pl Java13'
            }
        }
    }
}