@Library('way4sharedlib')_
pipeline {
    agent { node { label 'master' } }
    stages {
        stage('Example Build') {
            steps {
                echo "hello!"
            }
        }

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
                    def response = httpRequest 'http://localhost:8080/jenkins/api/json?pretty=true'
                    println("Status: "+response.status)
                    println("Content: "+response.content)
                }
            }
        }
    }
}