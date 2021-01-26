pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                script {
                    if (!isUnix()) {
                        bat('gradlew --no-daemon build')
                    } else {
                        sh('gradlew --no-daemon build')
                    }
                }
            }
        }
    }
}
