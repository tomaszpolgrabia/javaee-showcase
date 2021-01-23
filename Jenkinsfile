pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                def proc = "gradlew build".execute()
                println proc.text
            }
        }
    }
}
