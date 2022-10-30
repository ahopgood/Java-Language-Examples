pipeline {
    agent { label 'Java11' }
    stages {
        stage ('Parallel Builds') {
            parallel {
                stage('Build Java 6') {
                    agent { label 'Java6' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java6'
                    }
                }
                stage('Build Java 7') {
                    agent { label 'Java7' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java7'
                    }
                }
                stage('Build Java 8') {
                    agent { label 'Java8' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java8'
                    }
                }
                stage('Build Java 9') {
                    agent { label 'Java9' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java9'
                    }
                }
                stage('Build Java 10') {
                    agent { label 'Java10' }
                    steps {
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
                stage('Build Java 12') {
                    agent{ label 'Java12' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java12'
                    }
                }
                stage('Build Java 13') {
                    agent{ label 'Java13' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java13'
                    }
                }
                stage('Build Java 14') {
                    agent{ label 'Java14' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java14'
                    }
                }
                stage('Build Java 15') {
                    agent{ label 'Java15' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java15'
                    }
                }
                stage('Build Java 16') {
                    agent{ label 'Java16' }
                    steps {
                        sh 'mvn --version'
                        sh 'mvn clean install -pl Java16'
                    }
                }
            } //end parallel block
        } // end parallel stage
    } // end stages
        stage('Build Java 17') {
            agent { label 'Java17' }
            steps {
                git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
                sh '''
                    echo ${PATH}
                    echo $(lsb_release)
                '''
                sh 'mvn -version'
                sh 'mvn clean install -pl Java17'
            }
        }
    }
}