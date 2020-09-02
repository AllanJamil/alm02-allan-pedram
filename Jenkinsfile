pipeline {
//agent {
     // docker { image 'maven:3.6.3-slim' }
     // }
     agent any
     stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }
             
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                        allowMissing: false, 
                        alwaysLinkToLastBuild: false, 
                        keepAll: false, 
                        reportDir: 'target/surefire-reports/', 
                        reportFiles: 'index.html', 
                        reportName: 'Unit Tests', 
                        reportTitles: 'Unit Tests'
                    ])
                }
            }
        }
        stage('Test'){
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
           
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
                sh 'mvn -v'
        }
            post {
                always {
                    echo 'Saving artifacts..'
                    archiveArtifacts artifacts: 'target/*.jar', onlyIfSuccessful: true
                }
            }
        }
     }
}
