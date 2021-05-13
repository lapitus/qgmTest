@Library('way4sharedlib') _
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


                            def qgManager = new QgManager(this)

                            qgManager.checkFlag("sast")
                            qgManager.checkFlag("meta")

                            println(qgManager.getFlagStatus())

                        }
                    }
                }

                stage('Parallel 1') {
                    steps {
                        echo "hello!"
                    }
                }

                stage('Parallel 2') {
                    steps {
                        echo "hello!"
                    }
                }

            }

        }
    }
}