# Fortune Teller

A school project that tells your future depending on personal attributes. Built with BootStrap, Java, HTML and Javascript.

## Jenkins

The project folder contains two Jenkinfiles. Apply them to separately to different pipelines for desired goals.

#### Jenkinsfiledeployment

Use the Jenkinsfiledeployment for deploying the application directly on jenkins. The file contains only one stage with the command to run the application.

```sh
mvn spring-boot:run
```

**NOTE:** Once the application has been deployed, it's accessible via **port: _8081_** (http://localhost:8081/)

#### Jenkinsfile

Apply this Jenkinsfile to run the pipeline with these stages(Build, Test, Publish, Save Artifact).

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
Project created by **Pedram** and **Allan**.

*2020 Nackademin*

