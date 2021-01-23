pipeline {
    agent any;

    stages {
        stage('Build') {
            steps {
                script {
                    if (System.getProperty('os.name').startsWith('Windows')) {
                        bat('gradlew build')
                    } else {
                        sh('gradlew build')
                    }
                }
            }
        }
    }
}
