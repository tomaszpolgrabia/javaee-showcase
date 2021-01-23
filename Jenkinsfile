pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                script {
                    if (!isUnix() {
                        bat('gradlew build')
                    } else {
                        sh('gradlew build')
                    }
                }
            }
        }
    }
}
