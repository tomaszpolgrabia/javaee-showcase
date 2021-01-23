pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                script {
                    println("gradlew build".execute().text)
                }
            }
        }
    }
}
