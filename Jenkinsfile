pipeline {
    agent { label 'Java17' }
    stages {
//        stage('Build Java 6 -> 10') {
//            agent { label 'Java17' }
//            steps {
//                git credentialsId: 'github_token', url: 'https://github.com/ahopgood/Java-Language-Examples.git', branch: '${BRANCH_NAME}'
//                sh 'mvn -version'
//                sh 'mvn clean install -pl Java6,Java7,Java8,Java9,Java10'
//            }
//        }
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