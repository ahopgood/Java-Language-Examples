#!/usr/bin/env groovy
node {
    maven("Maven-3-0-5")
	stage('Preparation') { // for display purposes
	    // Get some code from a GitHub repository
	    git 'git://github.com/ahopgood/Java-Language-Examples.git'
	}
    stage('Build') {
        // Run the maven build
        if (isUnix()) {
            sh 'mvn clean package -pl Java6,Java7,Java8,Java9,Java10'
        }
    }
}