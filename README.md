# Fortune Teller

A school project that tells your future depending on personal attributes.

## Jenkins

The projectfolder contains two Jenkinfiles. Apply them to separate pipelines for desired goals.

### Jenkinsfiledeployment

Use the Jenkinsfiledeployment for deploying the application directly on jenkins. The file contains only one stage with the command;

```sh
mvn spring-boot:run
```

### Jenkinsfile

Use the Jenkinsfile consists of several stages(Build, Test, Publish, Save Artifact).

**NOTE:** This stage saves a war file. A reminder that this is a Spring Boot application running on tomcat.
```typescript
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
```

## Team
Project created by Pedram and Allan.

*2020 Nackademin*

