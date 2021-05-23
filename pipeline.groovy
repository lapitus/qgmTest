@Library('way4sharedlib') _

def qgManager = new QgManager(this)

pipeline {
    agent { node { label 'master' } }
    options { timestamps() }

    stages {

        stage('Example Build') {
            steps {
                echo "hello!2"
            }
        }


        stage("prl stages2") {
            parallel {

                stage('make classes') {

                    steps {
                        script {
                            echo 'Making classes2'
                            qgManager.checkFlag("meta")
                        }
                    }
                }

                stage('Parallel1') {
                    steps {
                        script {
                            qgManager.checkFlag("sast")
                        }
                    }
                }

                stage('Parallel2') {
                    steps {
                        script {
                            qgManager.checkFlag("ci")
                        }
                    }
                }

            }
        }

        stage("final stage2") {
            steps {
                script {
                    println(qgManager.getFlagStatus())
                    bat 'echo %PATH%'
                }
            }
        }
    }
}
