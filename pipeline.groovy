@Library('way4sharedlib')_
asd
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

                    aa

                    def aaa = new GlobalVars()
                    echo aaa.foo
                }
            }
        }
    }
}