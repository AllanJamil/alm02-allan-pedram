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

        }

        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }

        }

        stage ('Publish') {

            steps {
                echo 'Publishing Test Reports...'
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
                            reportName: 'Surefire Test Report',
                            reportTitles: 'Surefire Test Report'
                        ])

                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: false,
                            reportDir: 'target/site/jacoco/',
                            reportFiles: 'index.html',
                            reportName: 'Jacoco Test coverage',
                            reportTitles: 'Jacoco Test coverage'
                        ])
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
                    archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
                }
            }
        }
     }
}
