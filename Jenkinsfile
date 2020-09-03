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

                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/jacoco/',
                        reportFiles: 'index.html',
                        reportName: 'Test coverage',
                        reportTitles: 'Test coverage'
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

        stage ('Publish') {

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

                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: false,
                            reportDir: 'target/site/jacoco/',
                            reportFiles: 'index.html',
                            reportName: 'Test coverage',
                            reportTitles: 'Test coverage'
                        ])
                    }
                }
            }

        }

        stage('Saving artifacts') {
            steps {
                echo 'Saving war file ...'
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
