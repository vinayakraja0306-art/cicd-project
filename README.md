# Jenkins + Maven + Tomcat CI/CD Demo

A small Java web application for practicing a Jenkins Freestyle CI/CD job.

## Requirements

- JDK 17
- Apache Maven (or let Jenkins install Maven through Manage Jenkins > Tools)
- Git
- Apache Tomcat

## Build and test locally

```bash
mvn clean test package
```

The WAR file will be created at:

```text
target/jenkins-tomcat-demo.war
```

## Deploy to Tomcat manually

Copy the WAR file into Tomcat's `webapps` directory. The exact path depends on how Tomcat was installed.

Example for Ubuntu Tomcat 10:

```bash
sudo cp target/jenkins-tomcat-demo.war /var/lib/tomcat10/webapps/
```

Then open:

```text
http://localhost:8080/jenkins-tomcat-demo/
```

Use the port configured for your Tomcat instance.

## Jenkins job

Create a Freestyle project:

1. Configure Git as Source Code Management and enter this repository URL.
2. Add the Maven build step **Invoke top-level Maven targets**.
3. Select your configured Maven installation.
4. Set Goals to `clean test package`.
5. Archive `target/jenkins-tomcat-demo.war` as a build artifact.
6. Add a deployment step only after confirming the Tomcat service name, webapps path, port, and the Jenkins executor machine.

The project is a simple static web application packaged as a WAR. It is intentionally small for learning the Git → Jenkins → Maven test/package → Tomcat deployment flow.
