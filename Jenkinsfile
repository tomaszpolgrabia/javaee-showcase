pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                step {
                    sh("gradlew build")
                }
            }
        }
    }
}
