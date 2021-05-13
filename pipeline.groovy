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
            script{
                echo 'Making classes2'
                def yw = new YamlWorker(this)
                yw.doStuff()

                def aaa = new GlobalVars()
                echo aaa.foo
            }
        }
    }
}