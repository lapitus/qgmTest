@Library('way4sharedlib')_

pipeline {
    agent { node { label 'master' } }
    stages {
        stage('Example Build') {
            steps {
                echo "hello!"
            }
        }
    }
}