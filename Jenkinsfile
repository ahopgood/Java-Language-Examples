pipeline {
    agent { label 'Java11' }
    stages {
        stage ('Parallel Builds') {
            parallel {
                stage('Build Java 6') {
                    steps {
                        git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java6'
                    }
                }
                stage('Build Java 7') {
                    steps {
                        git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java7'
                    }
                }
                stage('Build Java 8') {
                    steps {
                        git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java8'
                    }
                }
                stage('Build Java 9') {
                    steps {
                        git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java9'
                    }
                }
                stage('Build Java 10') {
                    steps {
                        git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java10'
                    }
                }
                stage('Build Java 11') {
                    agent { label 'Java11' }
                    steps {
                        sh 'mvn -version'
                        sh 'mvn clean install -pl Java11'
                    }
                }
            } //end parallel block
        } // end parallel stage
    } // end stages
}