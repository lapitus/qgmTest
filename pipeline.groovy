@Library('way4sharedlib') _

def qgManager = new QgManager(this)

pipeline {
    agent { node { label 'master' } }

    stages {

        stage('Example Build') {
            steps {
                echo "hello!"
            }
        }



            stage("prl stages") {
                parallel {

                stage('make classes') {

                    steps {
                        script {
                            echo 'Making classes2'
                            def yw = new YamlWorker(this)
                            yw.doStuff()


                            qgManager.checkFlag("meta")


                        }
                    }
                }

                stage('Parallel 1') {
                    steps {
                        qgManager.checkFlag("sast")
                    }
                }

                stage('Parallel 2') {
                    steps {
                        script{
                            qgManager.checkFlag("ci")
                        }
                    }
                }

            }

        }

        stage("final stage") {
            steps {

                println(qgManager.getFlagStatus())
            }
        }
    }
}